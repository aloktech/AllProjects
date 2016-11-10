var fun1 = function (name) {
    print('Hi there from Javascript, ' + name);
    return "greetings from javascript";
};

var fun2 = function (object) {
    print("JS Class Definition: " + Object.prototype.toString.call(object));
};

var fun3 = function (name) {
    System.out.format("Hi there from Java, %s", name);
    return "greetings from java";
};

var MyJavaClass = Java.type('my.package.MyJavaClass');

var result = MyJavaClass.fun3('John Doe');
print(result);

// Hi there from Java, John Doe
// greetings from java