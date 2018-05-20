### ListPreference
  - Preference            View               含义
  - preference            TextView           文本框
  - CheckPreference       CheckBox           单选框
  - EditTextPreference    EditText           输入文本框
  - ListPreference        ListView           列表框
  - RingtonePreference    ___                铃声


  - PreferenceCategory类似于 LinearLayout  RelativeLayout
  - PreferenceScreen 所有Preference元素的根节点.


  - Activity继承PreferenceActivity, 然后onCreate()方法通过
  addPreferencesFromResource(R.xml.custom.preference)


  - android:key   --> id
  -        :defaultValue  --> 默认值
  -        :enabled    -- > 表示Preference是否可用状态.
  -        :title      -- > 大标题
  -        :summary    -- > 小标题
  -        :persistent -- > Preference元素所对应的值是否写入sharedPreference文件. true / false
  -        :dependency -- > 可用状态依赖另一个Preference
  -        :disableDependentsState:  -- > A 依赖 B   前者可用  则后者也可用.
  


  - 常用方法:
    - getKey()           setKey()
    - getSummary()       setSummary()
    - getText()          setText()

  
  - 具体看githup   Demo
  - Settings;  ScreenTimeoutSettings.java

对于该文件需要注意以下几点  
第一：位置。该文件的位置是在res/xml/下的。  
第二：格式，PreferenceScreen为根标签，ListPreference为子标签  
第三：标签属性含义  
android:key 唯一标识符，和android:id相类似，PreferenceManager可以以其为参数通过findPreference获取指定的preference  
android:title 整个屏幕的标题  
android:summary 选项的简单说明  
android:entries 弹出的对话框中，列表显示的文本内容，注意哦，这里指定的是一个数组  
android:entryValues 与android:entries相对应的值  
android:defaultValue 当对应值不存在时的默认值  
android:dialogTitle 弹出的对话框中的标题信息  

<PreferenceScreen  
xmlns:android="http://schemas.android.com/apk/res/android"  
android:key="screen_list"  
android:title="标题"  
android:summary="说明摘要"  
>  
<ListPreference  
android:key="myListPreference"  
android:title="标题"  
android:summary="说明摘要"  
android:entries="@array/list_entries"  
android:entryValues="@array/list_entries_value"  
android:dialogTitle="dialogTitle"  
android:defaultValue="@array/list_entries_value2"  
></ListPreference>  
  
</PreferenceScreen>   


### 邮件
  - 1. 分两部分: ① : Email  ② : UnifiedEmail
  - 2. ConvertsationPhotoTeaserView -- > 邮件列表
  - 3. Settings.java  -- > 数据库中取出签名
  - 4. MailActivity.java --> launch 界面
  - 5. Account.java -- > 初始化存储; 
  - 6. DBHelper.java -- > 数据库工具类.
  - 7. 根据邮件视图  一个界面 一个 fragment.
  - 8. 添加默认设置的签名:
    - 1. 在AccountSetupNamesFragment.java  -- > 添加数据的存储.
    - 只有当进入邮件前将默认的签名进行存储,才可以做到 --> 默认.

