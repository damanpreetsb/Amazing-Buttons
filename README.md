# Amazing-Buttons
FButton is a custom Button of Android with "Flat UI" concept. FButton's design get inspiration from designmono. This library is very small and highly customizable.

## Screenshot

## Including in your project
First add the following to your build.gradle(Project)
```
allprojects {
    repositories {
       ...
        maven { url "https://jitpack.io" }
    }
}
```

You just need to add the following dependency to your build.gradle.
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

Define xmlns:app="http://schemas.android.com/apk/res-auto" on root of your xml file

```<com.singh.daman.mybutton.MyButton
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
