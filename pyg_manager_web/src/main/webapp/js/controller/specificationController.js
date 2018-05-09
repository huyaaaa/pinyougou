app.controller("specificationController",

    //继承base

    function($scope,$controller,specificationService) {

        $controller("baseController",{$scope:$scope});
        //查找所有
        $scope.findAll = function () {

            specificationService.findAll().success(
                function (data) {
                    $scope.list = data;
                })
        }

        //查找单个
        $scope.findOne = function(id) {

            specificationService.findOne(id).success(
                function(data) {
                    $scope.entity = data;
                    $scope.entity.tbSpecification.specName=JSON.parse(data.tbSpecification.specName);
                    $scope.entity.list=JSON.parse(data.list);
                })
        }


        //分页
        $scope.findPage = function (page, rows) {
            specificationService.findPage(page,rows).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total;
            })
        }

        //添加品牌
        $scope.add=function () {
            //定义一个对象接受调用servise中的return
            var addOrUpdate;
            if ($scope.entity.id!=null){
                addOrUpdate=specificationService.update($scope.entity);
            }else{
                addOrUpdate=specificationService.add($scope.entity);
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
            specificationService.dele($scope.selectedItems).success(function (data){
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
            specificationService.search(page,rows,$scope.searchStr).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total;
            })
        }

        $scope.addTableRow=function () {
            $scope.entity.list.push({});
        }
        
        //删除行
        $scope.removeTableRow=function (index) {
            $scope.entity.list.splice(index,1);
        }
    })