SELECT o.owner_id, o.owner_name, count(DISTINCT category_id) AS different_category_count
FROM owner o
         LEFT JOIN article a ON o.owner_id = a.owner_id
         LEFT JOIN category_article_mapping c ON a.article_id = c.article_id
GROUP BY o.owner_id, o.owner_name
ORDER BY different_category_count DESC;
