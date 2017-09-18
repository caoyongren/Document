### 窗口化的逻辑
***

  1. AMS中控制保存着Window的info例如：窗口的尺寸/窗口的位置.
  2. 同一个栈中有多个Activity.
  3. AMS中 ActivityStack ActivityStack TaskRecord ActivityRecord
    对应：　TaskStack  Task  AppWindowToken
    AMS 和　WMS　中是一一对应．
  4. WMS中控制着每一个Window窗口，　SuperVisor通过relayoutWindow呈现
    绘制窗口，（窗口中的信息来自AMS）．
  5. WMS通过　View RootImpl来绘制View视图．
  6. 实现窗口的焦点的切换．
　　　　两个窗口，一个窗口A在上面，一个窗口B在下面.
        点击B: B窗口置顶．
        在一个栈Container中 存在B A (栈先进先出)
        本来B在栈底，点击后，Ｂ出栈然后重新进栈．
  7. 窗口：　PhoneWindow Decor
  
