# java-foundation

原 `Temp` 仓库重构后的 Java 基础实验仓库：并发、NIO/Netty、反射、设计模式、集合手写实现、面试题练习等。

> 定位：个人学习实验室，不是生产代码。各 demo 可独立运行 `main` 方法。

## 包结构

```
com.wgc.lab
├── algorithm/          # 算法：冒泡、队列等
├── collection/         # 手写 List / Iterator
├── concurrent/         # 多线程、锁、wait/notify、ThreadLocal、Echo 服务
├── designpattern/      # 单例、观察者、装饰器、策略、模板、责任链
├── reflection/         # 反射、注解、自定义消息转换
├── classloader/        # 自定义 ClassLoader
├── nio/                # BIO / NIO Server
├── netty/              # Netty 3.x 简易客户端/服务端
├── java8/              # Lambda 等
├── generic/            # 泛型
├── jdkapi/             # 常用 JDK API 小实验
├── util/               # 字符串、金额等工具
├── interview/          # 原 study_2020 面试/练习题
├── image/              # 图片处理试验
├── misc/               # BigDecimal、枚举等零散试验
└── base/               # 基础小例子
```

## 本次重构做了什么

- 统一包名前缀为 `com.wgc.lab.*`，修正 `reflact` / `simgle` / `annotatioin` 等拼写
- 合并嵌套的 `study_2020` 模块到 `interview`
- 删除临时文件、无意义类名（`aaa`/`ttt`）、drawio 草稿
- Maven 改为单模块 `jar`，更新依赖版本（Netty 仍为 3.x，因 demo API 绑定旧版）
- 仓库更名为 `java-foundation`

## 环境

- JDK 8+
- Maven 3.6+

```bash
mvn -q -DskipTests compile
```

## 建议学习顺序

1. `collection` → `algorithm`
2. `concurrent`（sync/volatile → lock → wait/notify）
3. `reflection` → `designpattern`
4. `nio` → `netty`
5. `interview` 查漏补缺
