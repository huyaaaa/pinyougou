app.controller("typeTemplateController",

    //继承base

    function($scope,$controller,typeTemplateService,brandService,specificationService) {

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
                    $scope.entity =data;


                    $scope.entity.brandIds=JSON.parse(data.brandIds);
                    $scope.entity.specIds=JSON.parse(data.specIds);
                    $scope.entity.customAttributeItems=JSON.parse(data.customAttributeItems);
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
            if ($scope.entity.id!=null){
                addOrUpdate=typeTemplateService.update($scope.entity);
            }else{
                addOrUpdate=typeTemplateService.add($scope.entity);
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
        
        //展示格式化
        $scope.strToJson= function (str,key) {
            var parse = JSON.parse(str);
            var value="";
            for (var i=0;i<parse.length;i++) {
                if (i>0){
                    value+=",";
                }
                value+=parse[i][key];

            }
            return value;
        }

        $scope.brandList={};
        $scope.findBrandList=function () {
            brandService.selectBrandMapList().success(function (data) {
                $scope.brandList={data:data};
            })
        }
        $scope.specificationList={};
        $scope.findSpecificationList=function () {
            specificationService.selectSpecMapList().success(function (data) {
                $scope.specificationList={data:data};
            })
        }
        $scope.addTableRow=function () {
            $scope.entity.customAttributeItems.push({});
        }

        //删除行
        $scope.removeTableRow=function (index) {
            $scope.entity.customAttributeItems.splice(index,1);
        }
    })