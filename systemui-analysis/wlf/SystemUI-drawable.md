##屏幕适配之drawable浅谈:
   屏幕分辨率： 指屏幕的宽和高的像素数， 比如HTC one V是480*800的。
   屏幕密度：   每inch的像素数，比如HTC one V， 是252 px/inch。
   px：  像素。一块显示屏是由很多的光点组成的，每一个光点就是一个像素。由于这些光点很小很密，想想看，在上面提到的3.7寸的手机上，横向有480个光点，纵向 有 800个光点，所以显示出来的文字或者图片才很细腻平滑。

   ppi： 和屏幕密度一个意思， 全称是pixel per inch.  是专业一点的叫法.

   dpi： dot per inch，每英寸的点数。在电子显示范畴内它和PPI是一个意思。 只有在打印时这个缩写才有意义，在打印领域不存在 PPI的叫法，只说DPI，它表示打 印机每英寸打印几个像素点。宽高同样像素下，dpi越大，打印出来的图案越小。

   dip： 或者叫dp，这是Android开发中特有的一种度量，称作屏幕无关像素， 它不表示任何具体的长度或者像素点， 这个值只有在具体屏幕密度的手机上，才会被转换为具体的像素值。 这个时候才会有实际意义。

                                     drawable 文件夹和屏幕密度的对应关系                       
	drawable-ldpi	drawable    drawable-mdpi    drawable-hdpi    drawable-xhdpi   drawable-xxhdpi  drawable-xxxhdpi
		     
           120 dpi      160 dpi       160 dpi          240 dpi          320 dpi            480 dpi         640 dpi

            0.75             1            1               1.5               2                  3               4  


Android图片选择策略
Android系统寻找图片的步骤是这样的：

1， 去屏幕密度对应的目录去找。如果找到就拿来用。

2， 如果没找到，就去比这个密度高一级的目录里面去找，如果找到就拿来用。

3， 如果没找到就继续往上找。以此类推。

4， 如果到了xxhdpi目录还没有找到的话，就会去比自身屏幕密度低一级的目录去找，如果低一级的目录>=hdpi，找到了就拿来用。

5， 如果没找到， 就去mdpi目录去找， 如果找到了，就拿来用。

6， 如果没找到，就去默认的drawble目录里去找， 如果找到了就拿来用。

7 ，如果没找到，再去最低的ldpi目录里去找。如果找到了，就拿来用。

8， 如果没找到， 那就是没找到了， 图片无法显示。（不过一般不会出现这种现象，因为如果每个目录都没有这个图片的话，你是编译不过的）

这里有两点需要注意：

①  首先会去比自己密度高的目录里去找，这是因为因为系统相信，你在密度更高的目录里会放置分辨率更大的图片，这样的话这个图片会被缩小，但同时显示效果不会有损失，但是如果优先去低一级别的目录去找的话， 找到的图片就会被放大，这样的话这个图片就会被拉扯模糊了。

 同一张图片，你在mdpi和xxhdpi目录各放了一份， 这个应用你现在运行在hdpi的手机上， 那应用会选择哪张图片呢。答案是xxhdpi目录里的。即便hdpi离mdpi更近一点！

②，如果在mdpi里找不到是不会直接去ldpi里找的， 而是先去默认的drawble目录里找，这是drawble目录和drawble-mdpi是一个级别的。


