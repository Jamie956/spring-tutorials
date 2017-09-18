# spring-boot-demo
hi spring boot

    SELECT  
        t2.all_day AS `日期`,    
        IFNULL(SUM(testSum), 0) AS `合计数量`,  
        COUNT(testSum) AS `出现行数`  
    FROM  
        (  
            SELECT  
                @rownum :=@rownum + 1 AS NO,  
                DATE_ADD(  
                    '2014-01-01',  
                    INTERVAL @rownum DAY  
                ) AS all_day  
            FROM  
                (SELECT @rownum := -1) r_init,  
                tst  
        ) t2  
    LEFT JOIN tst ON (  
        t2.all_day = DATE(tst.testDate)  
    )  
    WHERE  
        t2.all_day >= '2014-01-01'  
    AND t2.all_day <= '2014-01-07'  
    GROUP BY  
        t2.all_day;
        


-- get time by date    
SELECT  
    @row_num :=@row_num + 1 AS NO,  
    DATE_ADD('2016-12-01',INTERVAL @row_num DAY) AS all_day  
FROM  
    (SELECT @row_num := -1) random,t_merchant  
    
    
-- get time by week    
SELECT  
    @row_num :=@row_num + 1 AS NO,  
    DATE_ADD('2016-12-01',INTERVAL @row_num WEEK) AS all_day  
FROM
    (SELECT @row_num := -1) random,t_merchant
 
-- get time by month    
SELECT  
    @row_num :=@row_num + 1 AS NO,  
    DATE_ADD('2016-12-01',INTERVAL @row_num year) AS all_day  
FROM
    (SELECT @row_num := -1) random,t_merchant
    
    
    
-- t_merchant search by day    
SELECT  
    t2.all_day AS `date`,    
    IFNULL(SUM(default_tip_percentage), 0) AS 'tip',  
    COUNT(default_tip_percentage) AS 'tip count'  
FROM  
    (
		SELECT  
		    @row_num :=@row_num + 1 AS NO,  
		    DATE_ADD('2016-12-01',INTERVAL @row_num DAY) AS all_day  
		FROM  
		    (SELECT @row_num := -1) random,t_merchant  
    ) t2  
LEFT JOIN t_merchant ON (  
    t2.all_day = DATE(t_merchant.created_time)  
)  
WHERE  
    t2.all_day >= '2016-12-01'  
AND t2.all_day <= '2016-12-07'  
GROUP BY  
    t2.all_day
    
    
-- search by day
SELECT
	COUNT(1) AS 'count',
	DATE_FORMAT(created_time,'%Y-%m-%d') AS 'time'
FROM
	t_merchant
WHERE  
    created_time >= '2016-12-16 00:00:00'  
	AND created_time <= '2016-12-30 23:59:59'  
GROUP BY DATE_FORMAT(created_time,'%Y-%m-%d')

-- search by week
SELECT
	COUNT(1) AS 'count',
-- 	WEEK(created_time) as 'time',
	created_time
FROM
	t_merchant
WHERE	
    created_time >= '2017-01-01 00:00:00'  
	AND created_time <= '2017-2-01 23:59:59'  	
GROUP BY WEEK(created_time)

    
-- t_transaction search total and count by day    
SELECT
	t1.all_day AS 'date',
	IFNULL(SUM(amount), 0) AS 'total',
	COUNT(id) AS 'count'
FROM  
	(
		SELECT  
			@rownum :=@rownum + 1 AS rownum,
			DATE_ADD('2017-08-14',INTERVAL @rownum day) AS all_day  
		FROM  
			(SELECT @rownum := -1) random, t_transaction
	) t1
LEFT JOIN t_transaction ON ( 
	t1.all_day = DATE(t_transaction.updated_time)
)
WHERE
	t1.all_day >= '2017-08-14'
	AND t1.all_day <= '2017-08-16'
GROUP BY
	t1.all_day
 
	
	
-- t_transaction search total and count by week    
-- SELECT
-- 	t1.all_day AS 'date',
-- 	IFNULL(SUM(amount), 0) AS 'total',
-- 	COUNT(id) AS 'count'
-- FROM  
-- 	(
-- 		SELECT  
-- 			@rownum :=@rownum + 1 AS rownum,
-- 			DATE_ADD('2017-05-14',INTERVAL @rownum week) AS all_day  
-- 		FROM  
-- 			(SELECT @rownum := -1) random, t_transaction
-- 	) t1
-- LEFT JOIN t_transaction ON ( 
-- 	t1.all_day = DATE(t_transaction.updated_time)
-- )
-- WHERE
-- 	t1.all_day >= '2017-05-14'
-- 	AND t1.all_day <= '2017-07-14'
-- GROUP BY
-- 	t1.all_day
    
    
    
    
    
    
    
    
    
    
