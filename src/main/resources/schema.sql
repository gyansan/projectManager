
--プロジェクト
CREATE TABLE IF NOT EXISTS project_list (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(30) NOT NULL,
    project_summary TEXT
);

--画面
CREATE TABLE IF NOT EXISTS screen (
	id INT PRIMARY KEY AUTO_INCREMENT,
	project_id INT NOT NULL,
	screen_name VARCHAR(100),
	screen_summary TEXT,
	sort_key INT,
	FOREIGN KEY(project_id) REFERENCES project_list(id) ON DELETE CASCADE
);

--機能
CREATE TABLE IF NOT EXISTS screen_function (
    id INT AUTO_INCREMENT PRIMARY KEY,
    screen_id INT NOT NULL,
    function_name VARCHAR(100),
    function_summary TEXT,
    sort_key INT,
    is_implemented BOOLEAN NOT NULL DEFAULT false,
    FOREIGN KEY (screen_id) REFERENCES screen(id) ON DELETE CASCADE
);