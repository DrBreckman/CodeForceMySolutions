# A. Сделайте белой
### ограничение по времени на тест: 2 секунды
### ограничение по памяти на тест: 256 мегабайт
### ввод: стандартный ввод
### вывод: стандартный вывод

## Условие
У вас есть полоска из n
клеток. Каждая клетка либо белая, либо чёрная.

Вы можете один раз выбрать непрерывный отрезок клеток и покрасить их все в белый цвет. После этого действия все чёрные клетки этого отрезка станут белыми, а белые останутся белыми.

Какое минимальное количество подряд идущих клеток нужно покрасить в белый цвет, чтобы все n
клеток стали белыми.

## Входные данные
Первая строка входных данных содержит единственное целое число t
(1≤t≤104
) — количество наборов входных данных. Далее следуют описания наборов.

Первая строка каждого набора содержит одно целое число n
(1≤n≤10
) — длину полоски.

Вторая строка каждого набора содержит строку s
, состоящую из n
символов, каждый из которых либо 'W', либо 'B'. Символ 'W' обозначает белую клетку, а 'B' — чёрную. Гарантируется, что хотя бы одна клетка заданной полоски является чёрной.

## Выходные данные
Для каждого набора входных данных выведите единственное число — минимальную длину непрерывного отрезка клеток, который нужно покрасить в белый цвет, чтобы вся полоска стала белой.

## Примечание
В первом наборе входных данных для полоски «WBBWBW» минимальная длина отрезка для перекрашивания в белый цвет равна 4
. Необходимо перекрасить отрезок от 2
-й до 5
-й клетки в белый цвет (клетки нумеруются от 1
слева направо).