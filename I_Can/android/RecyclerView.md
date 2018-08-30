### RecyclerVeiw的使用及源码分析
***
#### 介绍
  - RecyclerView 是 android-support-v7-21 版本中新增的一个 Widgets,官方对于它的介绍则是：RecyclerView 是 ListView 的升级版本，更加先进和灵活。
  - 虽然RecyclerView充分考虑了它的扩展性，更灵活，更好用；
    - RecyclerView.Adapter
      - RecylerView.Adapter包含一种新型适配器，其实与以前我们使用的适配器基本类似，只是稍微有所不同，比如: viewholder它帮助我们封装好了，不用像以前使用listview的适配器一样自己写viewholder;
    - LayoutManager
      - 这个LayoutManager类决定视图被放在画面中哪个位置，但这只是它的众多职责之一。它可以管理滚动和循环利用。LayoutManager有一个叫做LinearLayoutManager的实现类,我们可以设置它的横向和纵向
    - ItemAnimator
      - ItemAnimator简单来说是会根据适配器上收到的相关通知去动画的显示组件的修改，添加和删除等。它会自动添加和移除item的动画。自带的默认效果也不错，已经非常好了.
    - ItemAnimator

  - RecyclerView的优缺点
    - RecyclerView本身它是不关心视图相关的问题的，由于ListView的紧耦合的问题，google的改进就是RecyclerView本身不参与任何视图相关的问题。它不关心如何将子View放在合适的位置，也不关心如何分割这些子View，更不关心每个子View各自的外观。更进一步来说就是RecyclerView它只负责回收和重用的工作，这也是它名字的由来。

##### RecyclerView.Adapter
  - onCreateViewHolder(ViewGroup parent, int viewType)
    - 方法就是用来填充新View;

  - getItemViewType(int position)
    - 方法是可以根据不同的position可以回不同的类型；

  - onBindViewHolder(MyViewHoder holder, int position)
    - 是将数据与视图绑定；

  - getItemCount()
    - 获取需要显示数据的总数；


#### 头部下拉刷新
  **方法：**
    - 自定义View
    - 嵌套SwipRefreshLayout布局.

#### 先介绍自定义View
  - 在正常的状态下，下拉刷新的头部是不可见的；
  - 当下拉到一定程度再将头部刷新显示出来。
    - addView(mContentLayout, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));

  - 下拉状态(手势监听)- RecyclerView中
    - 主要 MotionEvent.ACTION_DOWN
```
@Override
    public boolean onTouchEvent(MotionEvent e) {
        if (mLastY == -1) {
            mLastY = e.getRawY();
        }
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = e.getRawY();
                sumOffSet = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaY = (e.getRawY() - mLastY) / 2;//为了防止滑动幅度过大，将实际手指滑动的距离除以2
                mLastY = e.getRawY();
                sumOffSet += deltaY;//计算总的滑动的距离
                if (isOnTop() && !mRefreshing) {
                    mRefreshHeader.onMove(deltaY, sumOffSet);//移动刷新的头部View
                    if (mRefreshHeader.getVisibleHeight() > 0) {
                        return false;
                    }
                }
                break;
                default:
                    mLastY = -1; // reset
                    if (isOnTop()&& !mRefreshing) {
                        if (mRefreshHeader.onRelease()) {
                            //手指松开
                            if (mRefreshListener != null) {
                                mRefreshing = true;
                                mRefreshListener.onRefresh();//回调刷新完成的监听
                            }
                        }
                    }
                    break;
        }
        return super.onTouchEvent(e);
    }
```

**知识点:**
  - 计算滑动的距离
  - 通过自定义View为滑动的状 增加效果；
  - 监听回调， 回调的不止是触发还有 数据；

***
资料: http://www.wizardev.com/2017/12/02/%E8%87%AA%E5%B7%B1%E5%8A%A8%E6%89%8B%E5%86%99RecyclerView%E7%9A%84%E4%B8%8B%E6%8B%89%E5%88%B7%E6%96%B0/#more
