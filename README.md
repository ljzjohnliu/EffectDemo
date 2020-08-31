# EffectDemo
    Android动画汇总


## 帧动画
    逐帧动画(Frame Animation)，是最简单最直观的动画类型，它利用人眼的视觉暂留效应 ---- 也就是光对视网膜所产生视觉在光停止动作后，仍然保留一段时间的现象。
    开发者指定动画中每一帧对应的图片和持续时间，就可以开始播放动画。定义逐帧动画，可以采用 XML 资源文件或者代码实现。
    
    作用对象
    视图控件（View）
    
    如Android的TextView、Button等等
    不可作用于View组件的属性，如：颜色、背景、长度等等
    
    原理
    将动画拆分为 帧 的形式，且定义每一帧 = 每一张图片
    逐帧动画的本质：按序播放一组预先定义好的图片
    
    优缺点
    优点：使用简单、方便
    缺点：容易引起 OOM（ java.lang.OutOfMemoryError ），因为会使用大量 & 尺寸较大的图片资源
    
## 补间动画
    补间动画指的是， 设置好动画的开始属性 和 结束属性。 
    系统会在我们设置的动画时间内， 从开始时属性过渡到结束时候的属性。
    举个例子，一个控件向右平移100像素，其实改变的属性就是控件x轴的坐标。
    
    总结  
    补间动画系统提供了四种，分别是:平移、缩放、旋转、透明度。
    动画可以通过xml文件来描述，也可以通过java代码来实现。
    补间动画只能作用在view上。
    补间动画其实没有改变view的真实属性，比如动画后看到的view，是没办法点击的。
    可以通过组合动画，把四种动画结合使用。
    组合动画启动时，所有的子动画是同时启动的，如果要有先后顺序，可以通过子动画的延时执行来实现。
    
    
## 逐帧动画 & 补间动画存在一定的缺点：
    a. 作用对象局限：View
    即补间动画 只能够作用在视图View上，即只可以对一个Button、TextView、甚至是LinearLayout、或者其它继承自View的组件进行动画操作，但无法对非View的对象进行动画操作
    
    有些情况下的动画效果只是视图的某个属性 & 对象而不是整个视图；
    如，现需要实现视图的颜色动态变化，那么就需要操作视图的颜色属性从而实现动画效果，而不是针对整个视图进行动画操作
    b. 没有改变View的属性，只是改变视觉效果
    补间动画只是改变了View的视觉效果，而不会真正去改变View的属性。
    如，将屏幕左上角的按钮 通过补间动画 移动到屏幕的右下角
    点击当前按钮位置（屏幕右下角）是没有效果的，因为实际上按钮还是停留在屏幕左上角，补间动画只是将这个按钮绘制到屏幕右下角，改变了视觉效果而已。
    c. 动画效果单一
    补间动画只能实现平移、旋转、缩放 & 透明度这些简单的动画需求
    一旦遇到相对复杂的动画效果，即超出了上述4种动画效果，那么补间动画则无法实现。

## 属性动画
    1.作用对象：任意 Java 对象
    不再局限于 视图View对象
    
    2.实现的动画效果：可自定义各种动画效果
    不再局限于4种基本变换：平移、旋转、缩放 & 透明度
    
    3.特点
    作用对象进行了扩展：不只是View对象，甚至没对象也可以
    动画效果：不只是4种基本变换，还有其他动画效果
    作用领域：API11后引入的
    
    4.工作原理
    在一定时间间隔内，通过不断对值进行改变，并不断将该值赋给对象的属性，从而实现该对象在该属性上的动画效果
    可以是任意对象的任意属性
