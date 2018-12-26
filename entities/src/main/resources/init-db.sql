INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (1, 1, 1, 1, 'We are number one', 1);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (2, 2, 2, 2, 'Igra za dva', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (3, 3, 2, 2, 'Ubila si del mene', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (4, 4, 2, 2, 'Mladost', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (5, 5, 2, 2, 'Sambo pleše Marija', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (6, 6, 2, 2, 'Ob tebi', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (7, 7, 2, 2, 'Naj vedo', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (8, 8, 2, 2, 'Uživaj življenje', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (9, 9, 2, 2, 'Zakaj, zakaj', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (10, 10, 2, 2, 'Denar - sveta vladar', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (11, 11, 2, 2, 'Sexy bejba (feat. Natka)', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (12, 12, 2, 3, 'Višja sila', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (13, 13, 2, 3, 'Priložnost zamujena', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (14, 14, 2, 3, 'Med dvema ognjema', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (15, 15, 2, 3, 'Zla zidovi', 2);
INSERT INTO songs(id, stream_id, artist_id, album_id, title, user_id) VALUES (16, 16, 2, 3, 'Nihče ni popoln', 2);

ALTER SEQUENCE songs_id_seq RESTART WITH 17;
ALTER SEQUENCE streams_id_seq RESTART WITH 17;