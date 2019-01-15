[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![](https://jitpack.io/v/rezaiyan/ArcLayout.svg)](https://jitpack.io/#rezaiyan/ArcLayout)

# ArcLayout

Arc Layout is a view group with which you can add a arc-shaped container in your layout.
Two main variables are the direction and the curvature of the arc. Check the example below.

<p float="left">
<img src="https://raw.githubusercontent.com/rezaiyan/ArcLayout/master/sc/bottomNavigation.png" height="500">

<img src="https://raw.githubusercontent.com/rezaiyan/ArcLayout/master/sc/toolbar2.png" height="500">

<img src="https://raw.githubusercontent.com/rezaiyan/ArcLayout/master/sc/toolbar.png" height="500">
</p>

## Usage

By this instructions you can add this library and I will explain how use it.



### Add Maven to your root build.gradle

First of all, Add it to your root `build.gradle` at the end of repositories:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

### Add Dependency

Add the dependency to your app `build.gradle` file:

```
dependencies
{
    implementation 'com.github.rezaiyan:arclayout:1.0.1'
}
```

```xml

 <ir.alirezaiyan.arclayout.ArcRelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:arc_bottom_cropCurve="cropConcave|cropConvex"
        app:arc_top_cropCurve="cropConcave|cropConvex"
        app:arc_bottom_height="80dp"
        app:arc_top_height="80dp"
        app:arc_bottom_position="true"
        app:arc_top_position="true">

        <!-- YOUR CONTENT -->

    </ir.alirezaiyan.arclayout.ArcRelativeLayout>

```

License
--------

    Copyright 2016 Ali Rezaiyan, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
