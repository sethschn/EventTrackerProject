-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eventtrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `eventtrackerdb` ;

-- -----------------------------------------------------
-- Schema eventtrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eventtrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `eventtrackerdb` ;

-- -----------------------------------------------------
-- Table `emotion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emotion` ;

CREATE TABLE IF NOT EXISTS `emotion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tracker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tracker` ;

CREATE TABLE IF NOT EXISTS `tracker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `emotion_id` INT NOT NULL,
  `log_date` DATETIME NULL,
  `log_desc` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emotion_id_idx` (`emotion_id` ASC),
  CONSTRAINT `fk_emotion_id`
    FOREIGN KEY (`emotion_id`)
    REFERENCES `emotion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS etuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'etuser'@'localhost' IDENTIFIED BY 'etuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'etuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `emotion`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (1, 'Affection', 'A feeling of liking and caring for someone or something', 'Love');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (2, 'Lust', 'intense desire for an object, or circumstance fulfilling the emotion while already having a significant amount of the desired object', 'Love');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (3, 'Sexual Attraction', 'Attraction on the basis of sexual desire or the quality of arousing such interest', 'Love');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (4, 'Longing', 'Strong, persistent desire or craving, especially for something unattainable or distant', 'Love');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (5, 'Cheerfulness', 'A mood characterized by high spirits and amusement and often accompanied by laughter', 'Joy');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (6, 'Zest', 'Living life with a sense of excitement, anticipation, and energy', 'Joy');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (7, 'Contentment', 'an emotional state of satisfaction that can be seen as a mental state, maybe drawn from being at ease in one\'s situation, body and mind', 'Joy');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (8, 'Pride', 'The perceived value of a person or thing with which the subject has an intimate connection', 'Joy');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (9, 'Optimism', 'A belief or hope that the outcome of some specific endeavor, or outcomes in general, will be positive, favorable, and desirable', 'Joy');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (10, 'Enthrallment', 'A state of intense rapture that captures all your attention and elevates your mood to tremendous heights', 'Joy');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (11, 'Relief', 'When something unpleasant, painful or distressing has not happened or has come to an end', 'Joy');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (12, 'Surprise', 'A startle response experienced by animals and humans as the result of an unexpected event', 'Surprise');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (13, 'Irritability', 'Excitatory ability that living organisms have to respond to changes in their environment. abnormal or excessive sensitivity to stimuli', 'Anger');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (14, 'Annoyance', 'Characterized by irritation and distraction from one\'s conscious thinking', 'Anger');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (15, 'Rage', 'Intense, uncontrolled anger that is an increased stage of hostile response to a particularly egregious injury or injustice', 'Anger');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (16, 'Disgust', 'Response of rejection or revulsion to something potentially contagious or something considered offensive, distasteful, or unpleasant', 'Anger');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (17, 'Envy', 'Occurs when a person lacks another\'s superior quality, achievement, or possession and either desires it or wishes that the other lacked it', 'Anger');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (18, 'Suffering', 'An experience of unpleasantness and aversion associated with the perception of harm or threat of harm in an individual', 'Sadness');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (19, 'Sadness', 'Feelings of disadvantage, loss, despair, grief, helplessness, disappointment and sorrow', 'Sadness');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (20, 'Disappointment', 'The feeling of dissatisfaction that follows the failure of expectations or hopes to manifest', 'Sadness');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (21, 'Shame', 'An unpleasant self-conscious emotion typically associated with a negative evaluation of the self, withdrawal motivations, and feelings of distress, exposure, mistrust, powerlessness, and worthlessness', 'Sadness');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (22, 'Neglect', 'The failure to provide sufficient supervision, nourishment, or medical care, or the failure to fulfill other needs for which the victim cannot provide themselves', 'Sadness');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (23, 'Sympathy', 'The perception, understanding, and reaction to the distress or need of another life form', 'Sadness');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (24, 'Horror', 'The feeling of revulsion that usually follows a frightening sight, sound, or otherwise experience', 'Fear');
INSERT INTO `emotion` (`id`, `name`, `description`, `category`) VALUES (25, 'Anxiety', 'Feeling of uneasiness and worry, usually generalized and unfocused as an overreaction to a situation that is only subjectively seen as menacing', 'Fear');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tracker`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `tracker` (`id`, `emotion_id`, `log_date`, `log_desc`) VALUES (1, 1, '2020-04-11 00:00:00', 'I felt affection for the flowers');
INSERT INTO `tracker` (`id`, `emotion_id`, `log_date`, `log_desc`) VALUES (2, 2, '2020-04-11 00:00:00', 'I felt something');

COMMIT;

