# ArcLayout

Arc Layout is a view group with which you can add a arc-shaped container in your layout.
Two main variables are the direction and the curvature of the arc. Check the example below.

<p float="left">
<img src="https://raw.githubusercontent.com/rezaiyan/ArcLayout/master/sc/bottomNavigation.png" height="500">

<img src="https://raw.githubusercontent.com/rezaiyan/ArcLayout/master/sc/toolbar2.png" height="500">

<img src="https://raw.githubusercontent.com/rezaiyan/ArcLayout/master/sc/toolbar.png" height="500">
</p>

# Usage

```groovy
    implementation 'ir.alirezaiyan:arclayout:1.0.0'
```

```xml

 <ir.alirezaiyan.arclayout.ArcLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:arc_bottom_cropCurve="cropConcave|cropConvex"
        app:arc_top_cropCurve="cropConcave|cropConvex"
        app:arc_bottom_height="80dp"
        app:arc_top_height="80dp"
        app:arc_bottom_position="true"
        app:arc_top_position="true">

        <!-- YOUR CONTENT -->

    </ir.alirezaiyan.arclayout.ArcLayout>

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
