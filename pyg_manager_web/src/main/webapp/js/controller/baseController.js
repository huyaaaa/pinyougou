app.controller("baseController",
    function ($scope) {

        //刷新方法
        $scope.reloadList = function () {

            $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
        }

        //分页插件配置
        $scope.paginationConf = {
            currentPage: 1,
            totalItems: 10,
            itemsPerPage: 10,
            perPageOptions: [10, 20, 30, 40, 50],
            onChange: function () {
                $scope.reloadList();//重新加载
            }
        }

        //定义选中数组
        $scope.selectedItems=[];
        //checkbox选中方法
        $scope.updateSelection=function($event,id){
            //选中事件
            if ($event.target.checked){
                $scope.selectedItems.push(id);
                alert("选中了"+id);
            } else{
                //取消事件
                var pos = $scope.selectedItems.indexOf(id);
                $scope.selectedItems.splice(pos,1);
                alert("取消了"+id);

            }
        }
    }
    )