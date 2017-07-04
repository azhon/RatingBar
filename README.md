### 一：仿系统(RatingBar)的一个评分控件
### 二：效果图：
<img src="https://github.com/azhong1011/RatingBar/blob/version-1.1/screenshot/rating_bar_1.1.gif"/>

### 三：使用方法：
1.在build.gradle中添加依赖
```
compile 'com.azhon:ratingbar:1.2.0'
```
2.布局使用
```
<com.azhong.rattingbar.RatingBar
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    a_zhon:clickable="true"
    a_zhon:image_height="36dp"
    a_zhon:image_padding="3dp"
    a_zhon:image_width="36dp"
    a_zhon:star="1"
    a_zhon:star_count="5"
    a_zhon:star_img="@mipmap/star"
    a_zhon:unstar_img="@mipmap/unstar" />
```
3.布局属性介绍
```
    <!--填充图片-->
    <attr name="star_img" format="reference" />
    <!--默认图片-->
    <attr name="unstar_img" format="reference" />
    <!--图片宽度-->
    <attr name="image_width" format="dimension" />
    <!--图片高度-->
    <attr name="image_height" format="dimension" />
    <!--图片之间的间距-->
    <attr name="image_padding" format="dimension" />
    <!--图片总数-->
    <attr name="star_count" format="integer" />
    <!--填充的图片数量-->
    <attr name="star" format="integer" />
    <!--是否可以点击-->
    <attr name="clickable" format="boolean" />
```
## 四：Version-1.2 更新描述
   1.修复setStar(0)无效bug

   2.去除多余的v7包
## 五：博文链接：http://blog.csdn.net/a_zhon/article/details/70214584
## 六：LICENSE
   Copyright [2016-09-21] [阿钟]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
