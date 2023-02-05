
# create table
```mysql
-- test.staff definition
CREATE TABLE `staff` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```