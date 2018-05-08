app.controller("brandController",

    //继承base

    function($scope,$controller,brandService) {

        $controller("baseController",{$scope:$scope});
        //查找所有
        $scope.findAll = function () {

            brandService.findAll().success(
                function (data) {
                    $scope.list = data;
                })
        }

        //查找单个
        $scope.findOne = function(id) {

            brandService.findOne(id).success(
                function(data) {
                    $scope.items = data;
                })
        }


        //分页
        $scope.findPage = function (page, rows) {
            brandService.findPage(page,rows).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total;
            })
        }

        //添加品牌
        $scope.add=function () {
            //定义一个对象接受调用servise中的return
            var addOrUpdate;
            if ($scope.items.id!=null){
                addOrUpdate=brandService.update($scope.items);
            }else{
                addOrUpdate=brandService.add($scope.items);
            }
            addOrUpdate.success(function (data) {
                if (data.success){
                    alert(data.message);
                    $scope.reloadList();
                } else {
                    alert("Fail to Save entity")
                }
            })
        }

        //删除品牌
        $scope.dele=function () {
            brandService.dele($scope.selectedItems).success(function (data){
                    if (data.success){
                        //alert(data.message);
                        $scope.reloadList();
                    }else{
                        alert(data.message);
                    }
                }

            )
        }

        //定义搜索内容（封进自己写的包装工具类来避免乱码）
        $scope.searchStr={};
        //搜索分页查询
        $scope.search=function (page, rows) {
            brandService.search(page,rows,$scope.searchStr).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total;
            })
        }
    })