// conf.js

var HtmlReporter = require('protractor-html-screenshot-reporter');

var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter');

exports.config = {
    framework: 'jasmine',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    specs: ['spec.js'],
    multiCapabilities: [{
            browserName: 'firefox'
        }],
    onPrepare: function () {
        // Add a screenshot reporter and store screenshots to `/tmp/screnshots`: 
//        jasmine.getEnv().addReporter(
//                new HtmlReporter({
//                    baseDirectory: './result',
//                    takeScreenShotsOnlyForFailedSpecs: false,
//                    docTitle: 'BIM Assure Test Report'
//                }));

        jasmine.getEnv().addReporter(
                new Jasmine2HtmlReporter({
                    savePath: './results',
                    screenshotsFolder: 'images',
                    takeScreenShotsOnlyForFailedSpecs: true,
                    takeScreenshotsOnlyOnFailures: true
                }));
    },
    // Options to be passed to Jasmine-node.
    jasmineNodeOpts: {
        showColors: true // Use colors in the command line report.
    }
};
