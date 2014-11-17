(function(ng) {
  'use strict';

  var app;

  app = ng.module('tmApp', ['ngResource', 'ui.bootstrap']);
  
  // API base resource
  app.constant('tmApiUrl', 'http://localhost:8080/TaskManager/api');

  app.factory('tmAccountResource', ['$resource', 'tmApiUrl',
    function($resource, tmApiUrl) {
      return $resource(tmApiUrl+'/accounts/:id', {id: '@id'});
    }]);

  app.factory('tmCategoryResource', ['$resource', 'tmApiUrl',
    function($resource, tmApiUrl) {
      return $resource(tmApiUrl+'/categories/:id', {id: '@id'});
    }]);

  app.factory('tmTaskResource', ['$resource', 'tmApiUrl',
    function($resource, tmApiUrl) {
      return $resource(tmApiUrl+'/tasks/:id', {id: '@id'});
    }]);

  app.controller('tmMainCtrl', ['$rootScope', '$scope',
    function($rootScope, $scope) {
      $rootScope.selectedAccount = undefined;
      $scope.selectedAccount = undefined;
      $scope.$watch(function() {
        return $rootScope.selectedAccount;
      }, function() {
        $scope.selectedAccount = $rootScope.selectedAccount;
      });
      $scope.unselectAccount = function() {
        $rootScope.selectedAccount = undefined;
      };
    }]);

  app.controller('tmCategoryCtrl', ['$rootScope', '$scope', 'tmCategoryResource',
    function($rootScope, $scope, tmCategoryResource) {
      function refresh() {
        if ($rootScope.selectedAccount !== undefined)
          $scope.categories = tmCategoryResource.query({accountId: $rootScope.selectedAccount.id});
        else
          $scope.categories = [];
        $rootScope.$broadcast("tmCategoriesChanged", $scope.categories);
      }

      $scope.$watch(function() {
        return $rootScope.selectedAccount;
      }, function() {
        refresh();
      });

      $scope.createCategory = function() {
        var category = new tmCategoryResource();
        category.label = $scope.newLabel;
        category.hue = $scope.newHue;
        category.account = { id: $rootScope.selectedAccount.id };
        category.$save(function() {
          $scope.categories.push(category);
          $rootScope.$broadcast("tmCategoriesChanged", $scope.categories);
        });
      };
      $scope.deleteCategory = function(category) {
        category.$delete(function() {
            $scope.categories.splice($scope.categories.indexOf(category), 1);
            $rootScope.$broadcast("tmCategoriesChanged", $scope.categories);
        });
      };
    }]);

  app.controller('tmTaskCtrl', ['$rootScope', '$scope', 'tmTaskResource',
    function($rootScope, $scope, tmTaskResource) {
      $scope.categories = [];
      $scope.$on("tmCategoriesChanged", function(event, categories) {
        $scope.categories = categories;
      });

      function refresh() {
        if ($rootScope.selectedAccount !== undefined)
          $scope.tasks = tmTaskResource.query({accountId: $rootScope.selectedAccount.id});
        else
          $scope.tasks = [];
      }

      $scope.$watch(function() {
        return $rootScope.selectedAccount;
      }, function() {
        refresh();
      });

      $scope.categoryFor = function(task) {
        var f = "";
        ng.forEach($scope.categories, function(category) {
            if (category.id === task.category.id)
                f = category.label;
        });
        return f;
      };

      $scope.createTask = function() {
        var task = new tmTaskResource();
        task.category = { id: $scope.newCategory.id };
        task.label = $scope.newLabel;
        task.description = $scope.newDescription;
        task.importance = $scope.newImportance;
        task.urgency = $scope.newUrgency;
        task.account = { id: $rootScope.selectedAccount.id };
        task.$save(function() {
          $scope.tasks.push(task);
        });
      };
      $scope.deleteTask = function(task) {
        task.$delete(function() {
            $scope.tasks.splice($scope.tasks.indexOf(task), 1);
        });
      };
    }]);

  app.controller('tmAccountCtrl', ['$rootScope', '$scope', 'tmAccountResource',
    function($rootScope, $scope, tmAccountResource) {
      $scope.accounts = tmAccountResource.query();
      $scope.createAccount = function() {
        var account = new tmAccountResource();
        account.displayName = $scope.newDisplayName;
        account.email = $scope.newEmail;
        account.password = $scope.newPassword;
        account.$save(function() {
          $scope.accounts.push(account);
        });
      };
      $scope.selectAccount = function(account) {
        $rootScope.selectedAccount = account;
      };
      $scope.deleteAccount = function(account) {
        account.$delete(function() {
            $scope.accounts.splice($scope.accounts.indexOf(account), 1);
            if ($rootScope.selectedAccount === account)
                $rootScope.selectedAccount = undefined;
        });
      };
    }]);
})(angular);
