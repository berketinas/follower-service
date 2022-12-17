DROP TABLE IF EXISTS followers;

CREATE TABLE followers (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    follower UUID NOT NULL,
    following UUID NOT NULL,
    CONSTRAINT fk_follower
        FOREIGN KEY(follower)
            REFERENCES users(id),
    CONSTRAINT fk_following
        FOREIGN KEY(following)
            REFERENCES users(id)
);

INSERT INTO followers (follower, following)
VALUES ('a534fc6c-8c94-4911-9260-738e10a27fca', '58d57d08-3945-4b0c-8eba-627d2a92a022'),
       ('9fd4ba77-8659-40a2-bde9-d927125fb314', '18354101-cabf-423b-9a17-7f272770275f'),
       ('7fc24be9-6265-4a0a-9876-573dee9437d2', '18354101-cabf-423b-9a17-7f272770275f');