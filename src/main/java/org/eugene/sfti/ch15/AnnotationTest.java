package org.eugene.sfti.ch15;

/**
 * @author Eugene Wang
 * @since 2016/11/24
 */
public class AnnotationTest {
    public static void main(String[] args) {
        AnnotationExercise exercise = new AnnotationExercise();
        System.out.println("java调用scala变参示例：" + exercise.sum(1, 2, 3));
    }
}
