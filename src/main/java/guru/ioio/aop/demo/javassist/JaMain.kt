package guru.ioio.aop.demo.javassist

import guru.ioio.aop.demo.base.bean.SimpleBean
import javassist.ClassPool

fun main() {
    println("start ja")
    val classPool = ClassPool.getDefault()
    val clazz = classPool.get("guru.ioio.aop.demo.base.bean.SimpleBean")
    val method = clazz.getDeclaredMethod("process")
    method.insertBefore("{System.out.println(\"Ja start\");}")
    method.insertAfter("{System.out.println(\"Ja end\");}")
    clazz.writeFile("build/classes/java/main/")

    val outClazz = clazz.toClass()
    val obj = outClazz.getDeclaredConstructor().newInstance() as SimpleBean
    obj.process()
}
