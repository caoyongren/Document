多窗口的设计： 
  1. 窗口生成
    - ActivityStack的新建 和 PhoneWindow构造。
    - 添加辅助： Header 和 Border.
  2. 窗口刷新
    - WMS: 将应用的显示范围进行重新限制， 同时完成应用窗口的显示叠加，前后层次顺序判断，
           保证多个应用在多窗口模式下的正确运行。
    
//罗同学：分三个系统设计
1. APP子系统 
  - PhoneWindow 是APP子系统中主要关注窗口绘制的功能模块，  与 AMS  WMS 进行协同操作。
  - 辅助功能
    - Header Border 
  - 样式适配功能
    - 将Header 和 Border 在PhoneWindow中的层次放在DecorView上面。具有高优先级 （不确定）


2. AMS 系统
  - 每一个ActivityStack对应着一块屏幕区域用来和用户交互。多窗口模式的ActivityStack生成机制，其核心思想
    让应用的Main Activity能够自行启动一个ActivityStack；而通过其他应用的Activity来启动的应用则进行应用
    间状态的判断，并让应用程序可以得到一块专门的屏幕区域来显示交互内容。
  - 焦点切换：多窗口模式的Focus机制采取将Home系统应用一直保持在最下方的设计方式，重获Focus的AppStack会
    直接显示到最上方，其余AppStack则按照相应的顺序排列。（换一种实现方式）

3. WMS 子系统
  - 处理窗口之间的关系以及窗口变化对它的影响。
  - 通过 WMS 中与 ActivityStack 对应的 TaskStack 类的 relayoutWindow 方法来实现。 保证该方法通过TaskStack来和ActivityStack交互，保证Activity 和 Windows的屏幕范围一致。
  - 窗口叠加策略： Android 为不同的窗口设计了层次关系，各个窗口样式之间有绝对的叠加权重关系，为了保证窗口的叠加
    情况正确，我们实现了一套桌面化的窗口叠加权重；（针对系统应用-  思考其他更好的实现方式）
