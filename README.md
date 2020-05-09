怎么保证事务的切换，如：
```
@Switch(1)
public void listUser(){}

@Switch(2)
public void listGood(){
    listUser();
}
```
此时只能保证listUser是正确切换了数据源，而listGood数据源切换不回来了。