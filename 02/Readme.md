2023-05-Anton Cherepanov

Описание задания:
В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопросов).
Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.
Новый функционал:
Программа должна спросить у пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
Выполняется на основе предыдущего домашнего задания + , собственно, сам функционал тестирования.
Требования:
0. В приложении должна присутствовать объектная модель (отдаём предпочтение объектам и классам, а не строчкам и массивам/спискам строчек).

Все классы в приложении должны решать строго определённую задачу (см. п. 18-19 "Правила оформления кода.pdf", прикреплённые к материалам занятия).
Переписать конфигурацию в виде Java + Annotation-based конфигурации. Все зависимости должны быть настроены в IoC контейнере.
Добавить функционал тестирования студента.
Добавьте файл настроек для приложения тестирования студентов.
В конфигурационный файл можно поместить путь до CSV-файла, количество правильных ответов для зачёта - на Ваше усмотрение.
Помним, CSV с вопросами читается именно как ресурс, а не как файл.
Нужно написать интеграционный тест класса, читающего вопросы и юнит-тест сервиса с моком зависимости
Файл настроек и файл с вопросами, для тестов д.б. свои.
Scanner, PrintStream и другие стандартные типы в контекст класть не нужно! См. соответствующие слайды с занятия.
Весь ввод-вывод осуществляется на английском языке.
Помним, "без фанатизма" :)
Задание сдаётся в виде ссылки на pull-request в чат с преподавателем.
В pull-request должно присутствовать только то что касается текущей работы. Временные файлы и файлы IDE не должны попадать в PR.
Вопросы можно задавать в чате, но для оперативности рекомендуем Slack.
Код, написанный в данном ДЗ будет использоваться дальше в домашних заданиях №3 (Занятие №4), №4 (Занятие №5)
Данное задание засчитывает ДЗ №1 (Занятие №1).
Если Вы хотите засчитать, то обязательно пришлите ссылку в чат соответствующего предыдущего занятия.
