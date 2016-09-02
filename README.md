# Amazing-Buttons
Amazing-Buttons are buttons with custom shapes and UI. This library is small but highly customizable.

## Screenshot
![alt text](https://cloud.githubusercontent.com/assets/19357334/18201789/b74fa53a-7129-11e6-8451-5ec3ff717b72.png)

## Including in your project
Add the following to your build.gradle(Project)
```
allprojects {
    repositories {
       ...
        maven { url "https://jitpack.io" }
    }
}
```

Now, You just need to add the following dependency to your build.gradle.
```
dependencies {
    compile 'com.github.DamanSingh4321:Amazing-Buttons:1.0'
}
```

## Customizable attributes

| Attribute | default value | xml  | extra |
| ----------- |:-------------:| :-----:| :------:|
|button color | black   | fill_color     | color |
| stroke color| black   | stroke_color   | color |
| stroke width| 5sp     | stroke_width   | dimension |
| text        | Blank   | text           | String  |
| text size   | 20sp    | text_size      | dimension |
| text color  | black   | text_color     | color |
| button shape| circle  | button_type    | circle, star, rectangle, round_rectangle |
| roundness   | 5sp     | rect_roundness | dimension(only in round_rectangle) |

## Usage

Define ``` xmlns:app="http://schemas.android.com/apk/res-auto" ``` on root of your xml file

```
<com.singh.daman.mybutton.MyButton
       ...
        app:fill_color="@color/colorPrimaryDark"
        app:button_type="rectangle"
        app:stroke_color="@color/colorAccent"
        app:stroke_width="15sp"
        app:text="Hello"
        app:text_size="50sp"
        app:text_color="#ffff" />
    ...
     />
```

## Developed By
Damanpreet Singh

Special thanks to [Angad Singh](https://github.com/Angads25/)

## LICENCE
```
Copyright (C) 2016 Damanpreet Singh

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
