## Android 基础
***
### fragment
** 1. 应用**
  1. 静态使用fragment
  2. 动态使用fragment
  3. fragment回退栈
  4. fragment事务
  5. fragment的与Activity交互
  6. fragment如何与ActionBar集成
***
** 背景**
  - 适配平板和手机

**Fragment的生命周期**

  - onAttach(Activity)
    - 当Fragment与Activity发生关联调用
  - onCreateView(LayoutInflater, ViewGroup,Bundle)
    - 创建该Fragment的视图
  - onActivityCreated(Bundle)
    - 当Activity的onCreate方法返回时调用.
  - onDestoryView()
    - 与onCreateView想对应，当该Fragment的视图被移除时调用.
  - onDetach()
    - 与onAttach相对应，当Fragment与Activity关联被取消时调用.
  - 注意：除了onCreateView，其他的所有方法如果你重写了，必须调用父类对于该方法的实现.
  ***
  ##### 静态使用fragment
  **onCreateView(LayoutInflater , ViewGroup, Bundle)**
    -  return inflater.inflate(R.layout.fragment_content, container, false);  
  ##### 动态使用fragment
  **中间使用FrameLayout布局(替换布局)**
```
FragmentManager fm = getFragmentManager();  
FragmentTransaction transaction = fm.beginTransaction();  
mWeixin = new ContentFragment();  
transaction.replace(R.id.id_content, mWeixin);  
transaction.commit();  
```
  - 使用FragmentManager对Fragment进行动态的加载－replace.

**Fragment　API**
```
android.app.Fragment 主要用于定义Fragment

android.app.FragmentManager 主要用于在Activity中操作Fragment

android.app.FragmentTransaction 保证一些列Fragment操作的原子性，熟悉事务这个词，一定能明白~
```
获取FragmentManager的方式：
  - getFragmentManager() //v4包
主要的操作都是FragmentTransaction的方法。
  - FragmentTransaction transaction = fm.benginTransatcion();//开启一个事务
  - transaction.add()//Activity中添加一个Fragment.
  - transaction.remove()//从Activity中移除一个Fragment，如果被移除的Fragment没有添加到回退栈（回退栈后面会详细说），这个Fragment实例将会被销毁。
  - transaction.replace() //使用另一个Fragment替换当前的，实际上就是remove()然后add()的合体.
  - transaction.hide() //隐藏当前的Fragment，仅仅是设为不可见，并不会销毁.
  - transaction.show()//显示之前隐藏的Fragment.
  - detach()//会将view从UI中移除,和remove()不同,此时fragment的状态依然由FragmentManager维护。
  - attach() //重建view视图，附加到UI上并显示.
  - transaction.commit()//提交一个事务；
  ***
注意：常用Fragment的哥们，可能会经常遇到这样Activity状态不一致：State loss这样的错误。主要是因为：commit方法一定要在Activity.onSaveInstance()之前调用。
***
###### 管理Fragment回退栈
```
FragmentTwo fTwo = new FragmentTwo();  
FragmentManager fm = getFragmentManager();  
FragmentTransaction tx = fm.beginTransaction();  
tx.replace(R.id.id_content, fTwo, "TWO");  
tx.addToBackStack(null);  
tx.commit();
```
###### 特点:
FragmentOne实例不会被销毁，但是视图层次依然会被销毁，即会调用onDestoryView和onCreateView;

***
###### Fragment与Activity通信
  - 如果你Activity中包含自己管理的Fragment的引用，可以通过引用直接访问所有的Fragment的public方法;
  - 如果Activity中未保存任何Fragment的引用，那么没关系，每个Fragment都有一个唯一的TAG或者ID,可以通过getFragmentManager.findFragmentByTag()或者findFragmentById()获得任何Fragment实例，然后进行操作。
  - 在Fragment中可以通过getActivity得到当前绑定的Activity的实例，然后进行操作。
  - 注：如果在Fragment中需要Context，可以通过调用getActivity(),如果该Context需要在Activity被销毁后还存在，则使用getActivity().getApplicationContext();


***
#### 关于fragment的项目实战
  - MatthewFileM项目
***

#### 项目实战中的坑
  - 1. getActivity()空指针;
  - 2. 异常：Can not perform this action after onSaveInstanceState
  - 3. Fragment重叠异常-----正确使用hide、show的姿势;
  - 4. Fragment嵌套的那些坑;
  - 5. 未必靠谱的出栈方法remove();
  - 6. 多个Fragment同时出栈的深坑BUG;
  - 7. 深坑 Fragment转场动画;

***
**　概念: 内存重启**
  - 就是 app运行在后台的时候，系统资源紧张的时候导致把app的资源全部回收（杀死app的进程），这时把app再从后台返回到前台时，app会重启;

  ***
  ##### getActivity()空指针
  - 原因:
      - 在内存重启后，隐藏当前的Fragment已经onDetach()了宿主Activity;
      - 例如:  在pop了Fragment之后，该Fragment的异步任务仍然在执行，并且在执行完成后调用了getActivity()方法，这样就会空指针。
  - 解决：
    - 设置全局变量: mActivity;

```
protected Activity mActivity;
@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    this.mActivity = activity;
}

/**
*  如果你用了support 23的库，上面的方法会提示过时，有强迫症的小伙伴，可以用下面的方法代替
*/
@Override
public void onAttach(Context context) {
    super.onAttach(context);
    this.mActivity = (Activity)context;
}
```

#### 异常：Can not perform this action after onSaveInstanceState
  - 原因:
    - 在你离开当前Activity等情况下，系统会调用onSaveInstanceState()帮你保存当前Activity的状态、数据等，直到再回到该Activity之前（onResume()之前），你执行Fragment事务，就会抛出该异常！（一般是其他Activity的回调让当前页面执行事务的情况，会引发该问题;
  - 解决:
    - 用onActivityForResult()/onNewIntent()，可以做到事务的完整性，不会丢失事务;

```

// ReceiverActivity 或 其子Fragment:
void start(){
   startActivityForResult(new Intent(this, SenderActivity.class), 100);
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (requestCode == 100 && resultCode == 100) {
         // 执行Fragment事务
     }
 }

// SenderActivity 或 其子Fragment:
void do() { // 操作ReceiverActivity（或其子Fragment）执行事务
    setResult(100);
    finish();
}

```
***
#### Fragment重叠异常-----正确使用hide、show的姿势
  - 习惯:

```
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
// 在页面重启时，Fragment会被保存恢复，而此时再加载Fragment会重复加载，导致重叠 ;
    if(saveInstanceState == null){
    // 或者 if(findFragmentByTag(mFragmentTag) == null)
       // 正常情况下去 加载根Fragment
    }
}

```

```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity);

    TargetFragment targetFragment;
    HideFragment hideFragment;

    if (savedInstanceState != null) {  // “内存重启”时调用
        targetFragment = getSupportFragmentManager().findFragmentByTag(TargetFragment.class.getName);
        hideFragment = getSupportFragmentManager().findFragmentByTag(HideFragment.class.getName);
        // 解决重叠问题
        getFragmentManager().beginTransaction()
                .show(targetFragment)
                .hide(hideFragment)
                .commit();
    }else{  // 正常时
        targetFragment = TargetFragment.newInstance();
        hideFragment = HideFragment.newInstance();

        getFragmentManager().beginTransaction()
                .add(R.id.container, targetFragment, targetFragment.getClass().getName())
                .add(R.id,container,hideFragment,hideFragment.getClass().getName())
                .hide(hideFragment)
                .commit();
    }
}

```
***
#### fragment进出栈的问题
- 出栈不是remove而是变为null;
- 如果一次出栈两个
  - 再进栈，则出现一个null;

**解决**
　- 进行一次降序排序
```
public class FragmentTransactionBugFixHack {

  public static void reorderIndices(FragmentManager fragmentManager) {
    if (!(fragmentManager instanceof FragmentManagerImpl))
      return;
    FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) fragmentManager;
    if (fragmentManagerImpl.mAvailIndices != null && fragmentManagerImpl.mAvailIndices.size() > 1) {
      Collections.sort(fragmentManagerImpl.mAvailIndices, Collections.reverseOrder());
    }
  }
}

```
