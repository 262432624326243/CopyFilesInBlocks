# CopyFilesInBlocks
Надо копировать файл.
Файл копировать надо двумя потоками:
1 Поток вычитывает из файла и записывает данные в класс посредник
2 Поток берет данные из класса посредника и записывает в новый файл.