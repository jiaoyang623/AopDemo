package guru.ioio.aop.demo.asm

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.FileOutputStream


fun main() {
    println("process start")
    val reader = ClassReader("guru.ioio.aop.demo.base.bean.SimpleBean")
    val writer = ClassWriter(ClassWriter.COMPUTE_MAXS)
    val visitor = MyClassVisitor(writer)
    reader.accept(visitor, ClassReader.SKIP_DEBUG)
    val fos = FileOutputStream("build/classes/java/main/guru/ioio/aop/demo/base/bean/SimpleBean.class")
    fos.write(writer.toByteArray())
    fos.close()

    println("process end")
}

