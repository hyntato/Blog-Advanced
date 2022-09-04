# drop table if exists user;
# create table user (
#                       user_id int not null auto_increment,
#                       name varchar(128) not null,
#                       email varchar(128) not null,
#                       primary key (user_id)
# ) default character set utf8 collate utf8_general_ci;

# drop table if exists post;
# create table post (
#                       post_id int not null auto_increment,
#                       user_id int not null,
#                       title varchar(128) not null,
#                       content varchar(128) not null,
#                       primary key (post_id),
#                       foreign key (user_id) references user (user_id)
# ) default character set utf8 collate utf8_general_ci;

# drop table if exists comment;
# create table comment (
#                       comment_id int not null auto_increment,
#                       user_id int not null,
#                       post_id int not null,
#                       parent_comment_id int not null,
#                       content varchar(128) not null,
#                       is_deleted boolean not null,
#                       primary key (comment_id),
#                       foreign key (user_id) references user (user_id),
#                       foreign key (post_id) references post (post_id),
#                       foreign key (parent_comment_id) references comment (comment_id)
# ) default character set utf8 collate utf8_general_ci;

drop table if exists like_post;
create table like_post (
                      like_post_id int not null auto_increment,
                      user_id int not null,
                      post_id int not null,
                      primary key (like_post_id),
                      foreign key (user_id) references user (user_id),
                      foreign key (post_id) references post (post_id)
) default character set utf8 collate utf8_general_ci;


