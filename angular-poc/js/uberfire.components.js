var app = angular.module(uberfireAngularAppName, ['ngRoute']);
var ids_components = new Array();
var ids_perspectives = new Array();
uberfireAsExternalLibrary = true;
var parameters_components = {};
var parameters_perspectives = {};


app.directive('uberfirecomponent', function () {
    return {
        restrict: 'AE',
        replace: true,
        scope: true,
        transclude:true,
        template:  "<div></div>",
        link: function (scope, elem, attrs) {
            callUFComponent(attrs.id);
        }
    };
});

app.directive('uberfireangularperspective', function ($compile) {
    return {
        restrict: 'AE',
        replace: true,
        scope: true,
        link: function (scope, elem, attrs) {
            callUFPerspective(attrs.id);
            _scope = scope;
            _element = elem;
            _compile = $compile;
            waitForTemplate();
        }
    };
});

app.directive('uberfireperspective', function ($compile) {
    return {
        restrict: 'AE',
        replace: true,
        scope: true,
        template:  "<div></div>",
        link: function (scope, elem, attrs) {
            callUFPerspective(attrs.id);
        }
    };
});

var template;
var _scope;
var _element;
var _compile;

function templateIsReady(id, _template){
    template = _template;
}

function waitForTemplate() {
    if (!template) {
        window.setTimeout(waitForTemplate, 1000);
    }
    else{
        var linkFn = _compile(template);
        var content = linkFn(_scope);
        _element.append(content);
        _scope.$digest();
    }
}


function callUFPerspective(_id, _screenName) {
    prepareUfDataPerspective(_id, _screenName);
    waitForUFPerspective();
}

function callUFComponent(_id, _screenName) {
    prepareUfDataComponent(_id, _screenName);
    waitForUFComponent();
}

function prepareUfDataComponent(_id){
    ids_components.push(_id);
    var parameter = {};
    Array.prototype.slice.call(document.getElementById(_id).attributes).forEach(function(item) {
        parameter[item.name] = item.value;
    });
    parameters_components[_id] = parameter;
}
function prepareUfDataPerspective(_id){
    ids_perspectives.push(_id);
    var parameter = {};
    Array.prototype.slice.call(document.getElementById(_id).attributes).forEach(function(item) {
        parameter[item.name] = item.value;
    });
    parameters_perspectives[_id] = parameter;
}

function waitForUFPerspective() {
    if (typeof $uf_load_perspective == 'function') {
        while (ids_perspectives.length > 0) {
            var id = ids_perspectives.pop();
            $uf_load_perspective(parameters_perspectives[id])
        }
    }
    else {
        window.setTimeout(waitForUFPerspective, 1000);
    }
}

function waitForUFComponent() {
    if (typeof $uf_load_component == 'function') {
        while (ids_components.length > 0) {
            var id = ids_components.pop();
            $uf_load_component(parameters_components[id])
        }
    }
    else {
        window.setTimeout(waitForUFComponent, 1000);
    }
}
