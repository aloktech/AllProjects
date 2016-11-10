/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var screenSize = function () {

};

var confirmByUser = function (msg, callback) {
    if (confirm(msg)) {
        callback.@java.lang.Runnable::run()();
    }
};

