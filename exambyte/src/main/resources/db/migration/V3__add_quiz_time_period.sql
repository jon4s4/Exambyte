alter table quiz
add column start_time timestamp default null,
add column end_time timestamp default null,
add constraint check_time_period check (end_time is null or start_time is null or end_time > start_time);