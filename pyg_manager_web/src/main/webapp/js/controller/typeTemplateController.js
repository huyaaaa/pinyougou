app.controller("typeTemplateController",

    //继承base

    function($scope,$controller,typeTemplateService) {

        $controller("baseController",{$scope:$scope});
        //查找所有
        $scope.findAll = function () {

            typeTemplateService.findAll().success(
                function (data) {
                    $scope.list = data;
                })
        }

        //查找单个
        $scope.findOne = function(id) {

            typeTemplateService.findOne(id).success(
                function(data) {
                    $scope.items = data;
                })
        }


        //分页
        $scope.findPage = function (page, rows) {
            typeTemplateService.findPage(page,rows).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total;
            })
        }

        //添加品牌
        $scope.add=function () {
            //定义一个对象接受调用servise中的return
            var addOrUpdate;
            if ($scope.items.id!=null){
                addOrUpdate=typeTemplateService.update($scope.items);
            }else{
                addOrUpdate=typeTemplateService.add($scope.items);
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
            typeTemplateService.dele($scope.selectedItems).success(function (data){
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
            typeTemplateService.search(page,rows,$scope.searchStr).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total;
            })
        }
    })