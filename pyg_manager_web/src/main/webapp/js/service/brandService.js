app.service("brandService",

    function($http){

        //查询所有
        this.findAll=function(){
            return $http.get("../brand/findAll");
        }

        //查询单个
        this.findOne=function(id){
            return $http.get("../brand/findOne?id=" + id);
        }

        //分页查（已废弃）
        this.findPage=function(page,rows){
            return $http.get("../brand/findPage?page=" + page + "&rows=" + rows);
        }

        //条件分页查询
        this.search=function(page,rows,searchStr){
            return   $http.post("../brand/search?page=" + page + "&rows=" + rows,searchStr);
        }

        //添加单个
        this.add=function(items){

            return $http.post("../brand/add",items);
        }

        //修改单个
        this.update=function(items){
            return $http.post("../brand/update",items);
        }

        //删除操作
        this.dele=function(selectedItems){
            return $http.get("../brand/delete?ids="+selectedItems);
        }
        this.selectBrandMapList=function () {
            return $http.get("../brand/selectBrandList");
        }
    })