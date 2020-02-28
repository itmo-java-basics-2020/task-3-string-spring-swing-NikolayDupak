package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray)
    {
        if(inputArray == null || inputArray.length == 0)
            return new int[]{};
        int a = inputArray[inputArray.length-1];
        for (int i = inputArray.length - 1; i > 0 ; i-- )
            inputArray[i] = inputArray[i-1];
        inputArray[0] = a;
        System.out.println(inputArray);
        return inputArray;
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения
     * двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray)
    {
        if(inputArray == null || inputArray.length == 0)
            return 0;
        else if (inputArray.length == 1)
                return inputArray[0];
        int m1 = 0, m2 = 1;
        for(int i = 0; i < inputArray.length; i++)
        {
            if(inputArray[i] >= inputArray[m1])
                m1 = i;
        }
        for(int i = 0; i < inputArray.length; i++)
        {
            if(inputArray[i] >= inputArray[m2] && m1 != i)
                m2 = i;
        }
        return inputArray[m1]*inputArray[m2];
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input)
    {
        if(input == null)
            return 0;
        int len = input.length();
        double ablen = 0.0;
        for(int i = 0; i < len; i++)
            if(input.charAt(i) == 'a' || input.charAt(i) == 'A' || input.charAt(i) == 'b' || input.charAt(i) == 'B')
                ablen += 1;

         return (int)((ablen / len) * 100);
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input)
    {
        if(input == null || input == " ")
            return false;
        for(int i = 0; i < input.length(); i++)
            if(input.charAt(i) != input.charAt(input.length()-i-1))
                return false;
        return true;
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input)
    {
        String string = "";
        if(input == null)
            return "";
        int i = 0;
        while (input.length() > i)
        {
            char x = input.charAt(i);
            int ind = 0;
            while (input.charAt(i) == x)
            {
                ind += 1;

                i++;
                if(i == input.length())
                    break;
            }
            string += x + Integer.toString(ind);

        }
        return string;
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two)
    {
        if(one == null || two == null)
            return false;
        char[] chars = one.toCharArray();
        Arrays.sort(chars);
        char[] chars2 = two.toCharArray();
        Arrays.sort(chars2);
        String a = chars.toString();
        String b = chars2.toString();
        if(Arrays.equals(chars, chars2))
            return true;
        else
            return false;

        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s)
    {
        if(s == null || s.length() < 1)
            return false;
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            char x = s.charAt(i);
            for (int j = 0; j < c.length; j++)
                if(c[j] == x)
                    return false;

             c[i] = x;
        }
        return true;
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m)
    {
        if(m == null || m[0].length < 1)
            return new int[][]{{},{}};
        int[][] a = new int[m[0].length][m[0].length];
        for (int i = 0; i < m[0].length; i++)
        {
            for (int j = 0; j < m[0].length; j++)
                a[i][j] = m[j][i];
        }
        return a;
     //   throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator)
    {
        if(inputStrings == null || inputStrings.length == 0)
            return "";
        String res = "";
        if(separator == null)
            separator = ' ';
        for (int i = 0; i < inputStrings.length-1; i++)
        {
            res += inputStrings[i] + separator;
        }
        return res + inputStrings[inputStrings.length-1];
       // return null; // TODO solve
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и
     * возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix)
    {
        if(inputStrings == null || prefix == null)
            return 0;
        int ind = 0;
        for(int i = 0; i < inputStrings.length; i++)
        {
            int s = 0;
            for(int j = 0; j < prefix.length(); j++)
            {
                if(inputStrings[i].charAt(j) == prefix.charAt(j))
                    s++;
                else
                    break;

            }
            if(s == prefix.length())
                ind++;
        }
        return ind;
        //return 0; // TODO solve
    }
}
