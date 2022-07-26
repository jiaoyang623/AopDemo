package guru.ioio.asm.demo.asm

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class MyClassVisitor(visitor: ClassVisitor) : ClassVisitor(Opcodes.ASM5, visitor) {
    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        println("class.visitClass: $name")
        cv.visit(version, access, name, signature, superName, interfaces)
    }

    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        println("class.visitMethod: $name")
        val methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions)
        return if (!name.equals("<init>") && methodVisitor != null) {
            MyMethodVisitor(methodVisitor)
        } else {
            methodVisitor
        }
    }
}
