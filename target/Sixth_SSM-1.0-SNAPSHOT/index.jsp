<%--
  Created by IntelliJ IDEA.
  User: Shenshuxin
  Date: 2021/6/26
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://cdn.staticfile.org/angular.js/1.6.3/angular.min.js"></script>

  </head>
  <body>
  <div ng-app="myApp" ng-controller="myCon" ><br><br><br>
    当前会话sessionID：{{getse}}<br>
    当前全局context的内存地址：{{getco}}<br><br>
    ID:<input ng-model="pg.v_id"/><br>
    NAME:<input ng-model="pg.v_name"/>
    <button ng-click="afun()">增加一条</button><br>
    <button ng-click="qfun()">增查询所有</button><br>
    <br>
    <h1 style="color: red">{{mydbV}}</h1>
    <br >
    <br>
    <br>
<h3>调用查询接口使用了幂等操作:即在当前用户下，如果上面的输入框的值没有重新发生变化的话，那么查询只能查询一次，再次点击此按钮，不会返回任何结果！</h3>
  </div>
  <script>
    var app = angular.module('myApp', []);
    app.controller('myCon',function ($scope,$http,$timeout) {
      $scope.getse="";
      $scope.getco="";

       $scope.mydbV="";
       $scope.pg={};

       $scope.$watch("mydbV",function () {
         $timeout(function () {
           $scope.mydbV="";
           $scope.$applyAsync();
         },3000,true)
       })

       $scope.afun = function () {
          if ($scope.pg.v_id == undefined || $scope.pg.v_name == undefined ){
            alert("参数为空")
            return;
          }
          $http
            .post('s/addd.do',$scope.pg)
            .then(function (response) {
              $scope.mydbV=$scope.pg.v_name+"添加成功";
              $scope.$applyAsync();
            });
       };
       $scope.qfun = function () {
         $http
           .post('s/quee.do',$scope.pg)
           .then(function (response) {
             var a1 = response.data.alls;
             $scope.getse = response.data.se;
             $scope.getco = response.data.co;
             $scope.mydbV = "返回的值:"+a1 ;
             $scope.$applyAsync();
           });
       };
    });
  </script>
  </body>
</html>
