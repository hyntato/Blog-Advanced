# ERD 설계

### 상세 기획서 기반으로 ERD 설계
[게시판 상세 기획서 · Well-Founded-Confidence/Blog-Advanced Wiki](https://github.com/Well-Founded-Confidence/Blog-Advanced/wiki/%EA%B2%8C%EC%8B%9C%ED%8C%90-%EC%83%81%EC%84%B8-%EA%B8%B0%ED%9A%8D%EC%84%9C)

### Version 2.0
![ERD ver2](https://user-images.githubusercontent.com/56067179/186689875-5455f94c-a8ae-429a-bd30-7cacec455156.png)

### user (사용자)

- id (pk)
- name
- email
- password
- created_at
- modified_at

### post (게시글)

- id (pk)
- author_id (fk)
- title
- content
- created_at
- modified_at

### comment (댓글)

- id (pk)
- user_id (fk)
- post_id (fk)
- content
- parent_comment_id (fk)
- is_deleted
- created_at
- modified_at

### like_post (게시글 좋아요)

- user_id (pk, fk)
- post_id (pk, fk)
- created_at
- modified_at

### like_comment (댓글 좋아요)

- user_id (pk, fk)
- comment_id (pk, fk)
- created_at
- modified_at

### hit (조회 수)

- post_id (pk, fk)
- count
- created_at
- modified_at

### hit session (조회 수 세션)
: 개시글의 유효한 조회수를 카운팅 하기 위한 테이블

- user_id (pk, fk)
- post_id (pk, fk)
- created_at
- modified_at
