# 打印机说明书

## Note:
  - 打印属于Openthos模块之一。它的加入使阁下可以更方便的进行打印，使办工更便捷。
  - 了解更多请查看下方（打印功能详情介绍）
***

## 功能模块

  - 打印任务管理器
  - 系统打印服务
  - 已添加设备
  - 扫描本地打印机
  - 添加网络打印机
  - 实施打印

## 功能详情

  - 打印任务管理器 --（*暂停 开始 取消*）
    - 点击打印任务管理器： 对正在进行的打印任务实施暂停 开始 取消 操作。
  - 系统打印服务 --（*开启 关闭*）
    - 点击系统打印服务： 对本地打印服务进行关闭和开启。
  - 已添加设备
    - 点击已添加设备的条目： 
      - 显示已添加设备的信息：
        - 打印测试页： 就是对打印机一种功能的测试。
        - 微调： 就是调打印的Page Size(纸张大小) Paper Tray(纸位置) Paper type(纸类型) Double-Silded Printing(双面打印)
                Color Mode(颜色模式) Draft Mode(是否拉伸) Image Enhancement(是否图片增强)
  - 扫描打印机 --(*扫描本地打印设备*)
    - 点击扫描本地打印机： 进行对本地打印机进行搜索。
  - 添加网络打印机 --(*网络打印*)
    - 点击添加网络设备：
![](https://github.com/openthos/systemui-analysis/blob/master/ImageView/add%20printer.png)
      - 填写打印的名字：这个名字是这次打印的名称，默认时netprinter.
      - 填写打印url地址： 填写网络打印的地址，实验室打印机：socket://192.168.0.211
      - 请选择一个制造商： 选择制造商，这里默认选择Fuji
      - 请选择一个驱动： 针对不同的制造商选择不同的驱动，这里默认选择驱动Xerox
  - 分享打印机： 就是可以在其他电脑上进行网络共享网络打印机。
  - 实施打印
      - 启动WPS Office: 通过右下角的红色小圆球进行新建文件（word）, 然后添加自己需求打印的内容。
![](https://github.com/openthos/systemui-analysis/blob/master/ImageView/create%20word.png)
      - 点击文件： 选择打印 --> 对页码范围和打印范围和版数进行选择(通常选择默认) --> 点击打印 
          --> 选择打印服务  -- > 选择系统打印服务  --> 点击打印的图标 --> 打印完成。
![](https://github.com/openthos/systemui-analysis/blob/master/ImageView/osprint.png)
                                             

