## 对比TaskBar 和 StartupMenu
  - 1. 使用的基本方法
    - StartupMenu： 直接是集成在任务栏上，点击StartupMenu图标就可以弹出开始菜单，然后进行应用的选择打开，再次点击关闭。
    - TaskBar： TaskBar所具有的功能更多一点，你可以对其进行设置，界面更加美化。具体的设置内容  
    
||设置选项|功能|
|---|---|---|
|General settings|Start menu layout|设置start menu 展现的排列模式：list or grid|
||Position on screen|设置start menu所在的位置以及方向（共8个方向）|
||Sear bar visibility|是否显示搜索框以及设置输入键盘的类型（虚拟键盘和实际键盘）|
||configure apps in start menu|设置应用展示的方式（过滤应用和置顶应用）|
||Show scrollbar on start menu|设置Start menu右侧导航条的展示方式|
||Collapse TaskBar when selecting items||
||Automatically collapse TaskBar||
||Alternative position for collapse button||
||Anchor Taskbar when screen rotates||
||Launch on boot||
||System notification settings||
||||
|Appearance|Theme|设置Start menu主题颜色（Dark Light）|
||Icon pack||
||Background tint||
||Accent color||
||Hide button while Taskbar is collapsed||
||Use Taskbar logo as start menu icon||
||Show shortcut icon for pinned apps||
||Visual feedback when selecting icons||
||Transparent start menu||
||Use masks for unthemed icons||
||Reset colors to default||
||||
|Recent apps|||
||||
|Freeform mode|||
||||
|Advanced features|||

<br />

  - 2. TaskBar的实现效果展示
  
  <br />
  
  - 3. TaskBar已经具备的功能
    - 1.展示本机安装的应用
    - 2.固定常用应用到任务栏
    - 3.右键弹出菜单对单个应用的操作（固定到任务栏，卸载，查看应用信息等）
    
  <br />
  
  - 4. TaskBar相对StartupMenu优缺点
    - 1.缺少一些应用排序方式（比如按安装时间，使用频率），但是TaskBar可以自定义过滤应用和置顶应用
    - 2.TaskBar弹出右键菜单的时候会TaskBar会隐藏，看起来很空旷
    - 3.TaskBar的右键菜单在鼠标移动的时候没有选中某一项的提示
    - 4.TaskBar比StartupMenu的展示风格更加多样化
    - 5.TaskBar打开的应用不会在TaskBar上显示出来
  <br /> 
 
  - 5.TaskBar增加相对StartupMenu缺失功能的实现及难易把握
    - 1.与桌面（Launcher）的关系
    - 2.如何把打开的应用放到taskbar上
    - 3.如何让taskbar在弹出右键菜单的时候不消失，点击后才消失
    - 4.如何给弹出的右键菜单添加hover事件
    - 5.如何处理navigation bar
  <br />
  
  - 6.TaskBar源码移植到系统中的大概问题是否好解决．
    - TaskBar源码已经移植到android 7.1 系统上
  <br /> 
  
  - 7.TaskBar的实现逻辑
    - 1、在程序运行的时候会启动TaskbarService
    - 2.在TaskbarService里将加载start menu的布局文件.通过drawTaskbar()的windowManager.addView(layout, params)将这个布局显示在界面
        （layout：布局的资源文件，params设置这个资源文件显示的位置，大小等属性）
    - 3.弹出的应用列表，搜索等内容是在StartMenuService里实现展示的。主要方法是drawStartMenu()。
    - 4.打开Taskbar应用所出现的设置页面是属于这个app的，而显示在屏幕的start menu是属于window的。这个之间的通信通过BroadcastReceiver。
       
  
