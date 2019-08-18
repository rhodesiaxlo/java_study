#1 导入 junit, 设置 test 域
#2 创建 IPizza  IPizzaShop  创建第一个 shop 和 2 种披萨
#3 在pizza Shop 种根据 type 判断生成何种pizza, order pizza

#4 创建 IPizzaShop 接口 ，创建 BasePizzaShop 基类，创建 简单工厂对象 factory
#5 其他问题 现在问题 为 shop factory pizza 

#6 随着披萨店的增多，很多披萨店需要有自己的风味来迎合本地客户， 因为 这个需求是依赖披萨店的
此时，降创建披萨对象的方法由简单工厂对象转移到披萨店更为合理

#7 但是一些披萨店偷工减料，胡乱配方，影响了口碑，对流程和原料需要做一定的管控
#8 构造方法和继承 tostring