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
VALUES ('00360aba-851f-4338-aa69-0f38038c0b81', '69cd611c-5d3e-49ce-8f71-c1565b198677'),
       ('a63b2809-3c6d-4e0c-b9be-022133543b8a', 'd443a0eb-4aeb-424e-aaa8-06199b642a29'),
       ('8cda377a-dbee-4b21-b08b-c2d439212568', 'd443a0eb-4aeb-424e-aaa8-06199b642a29');