//Enums are used to define the set of named constants
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
var bg = Color.Blue;
var bg2 = Color.Red;
console.log(bg);
console.log(bg2);
