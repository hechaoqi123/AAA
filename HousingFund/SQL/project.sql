/*
Navicat MySQL Data Transfer

Source Server         : MyFirst
Source Server Version : 50610
Source Host           : 127.0.0.1:3306
Source Database       : project

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2018-09-20 08:22:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for beforereturn
-- ----------------------------
DROP TABLE IF EXISTS `beforereturn`;
CREATE TABLE `beforereturn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `indLoan` varchar(255) DEFAULT NULL,
  `BorrID` int(11) DEFAULT NULL,
  `iphone` varchar(255) DEFAULT NULL,
  `returnMoney` varchar(255) DEFAULT NULL,
  `afterMoney` varchar(255) DEFAULT NULL,
  `afterlixi` varchar(255) DEFAULT NULL,
  `returnType` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `money` int(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `w` (`BorrID`),
  CONSTRAINT `w` FOREIGN KEY (`BorrID`) REFERENCES `borrowmoneyagreement` (`BorrowMoneyAgreementID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of beforereturn
-- ----------------------------
INSERT INTO `beforereturn` VALUES ('5', '6217002710000684874', '6', '13569541609', '41666', '458334', null, '部分还款', '已通过', '10', null);

-- ----------------------------
-- Table structure for borrowmoneyagreement
-- ----------------------------
DROP TABLE IF EXISTS `borrowmoneyagreement`;
CREATE TABLE `borrowmoneyagreement` (
  `BorrowMoneyAgreementID` int(11) NOT NULL AUTO_INCREMENT,
  `RepaymentPlanDetailsiID` int(11) DEFAULT NULL,
  `LoanFinalID` int(11) DEFAULT NULL,
  `LoanBookID` int(11) DEFAULT NULL,
  `BorrowerName` varchar(30) DEFAULT NULL,
  `BorrowMoneyNumber` varchar(20) DEFAULT NULL,
  `BorrowerFixedYear` int(11) DEFAULT NULL,
  `BorrowerAnnualRate` float DEFAULT NULL,
  `RepaymentMode` varchar(20) DEFAULT NULL,
  `GuarantorInfo` varchar(200) DEFAULT NULL,
  `CollateralInfo` varchar(200) DEFAULT NULL,
  `Coborrower` varchar(50) DEFAULT NULL,
  `RepaymentAccount` varchar(50) DEFAULT NULL,
  `BorrowerIDNo` varchar(50) DEFAULT NULL,
  `BorrowerPhone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BorrowMoneyAgreementID`),
  KEY `FK_r_32` (`LoanFinalID`),
  KEY `FK_r_33` (`RepaymentPlanDetailsiID`),
  KEY `FK_r_38` (`LoanBookID`),
  CONSTRAINT `FK_r_32` FOREIGN KEY (`LoanFinalID`) REFERENCES `loanfinal` (`LoanFinalID`),
  CONSTRAINT `fk_r_33` FOREIGN KEY (`RepaymentPlanDetailsiID`) REFERENCES `repaymentplandetails` (`RepaymentPlanDetailsiID`),
  CONSTRAINT `FK_r_38` FOREIGN KEY (`LoanBookID`) REFERENCES `loanbook` (`LoanBookID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowmoneyagreement
-- ----------------------------
INSERT INTO `borrowmoneyagreement` VALUES ('6', null, null, '6', '张一', '50.0', '12', '2.75', '等额本息还款', null, null, null, '15', '410025199711014925', '2018/09/01');

-- ----------------------------
-- Table structure for causeofextraction
-- ----------------------------
DROP TABLE IF EXISTS `causeofextraction`;
CREATE TABLE `causeofextraction` (
  `ReasonNo` int(11) NOT NULL AUTO_INCREMENT,
  `ExtractDetailsID` int(11) DEFAULT NULL,
  `CauseDescription` varchar(100) DEFAULT NULL,
  `Remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ReasonNo`),
  KEY `FK_r` (`ExtractDetailsID`),
  CONSTRAINT `FK_r` FOREIGN KEY (`ExtractDetailsID`) REFERENCES `extractdetails` (`ExtractDetailsID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='  原因\r\n购买、建造、翻建、大修自住住房\r\n偿还购房贷款本息的\r\n离职、退休、死亡\r\n                                      -';

-- ----------------------------
-- Records of causeofextraction
-- ----------------------------
INSERT INTO `causeofextraction` VALUES ('1', null, '购买房屋', '购买房屋所需信息');
INSERT INTO `causeofextraction` VALUES ('5', null, '其他', '其他');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------

-- ----------------------------
-- Table structure for coborrower
-- ----------------------------
DROP TABLE IF EXISTS `coborrower`;
CREATE TABLE `coborrower` (
  `CoborrowerID` int(11) NOT NULL AUTO_INCREMENT,
  `CoborrowerAccount` varchar(100) DEFAULT NULL,
  `CoborrowerName` varchar(100) DEFAULT NULL,
  `CoborrowerPhone` varchar(100) DEFAULT NULL,
  `CoborrowerAddress` varchar(100) DEFAULT NULL,
  `CoborrowerUtinName` varchar(50) DEFAULT NULL,
  `CoborrowerIDNo` varchar(50) DEFAULT NULL,
  `CoborrowerMonthMoney` float(8,2) DEFAULT NULL,
  `Relation` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CoborrowerID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coborrower
-- ----------------------------
INSERT INTO `coborrower` VALUES ('2', '15', '张一', '13569541609', null, 'AAA软件教育', '410025199711014925', null, '夫妻');

-- ----------------------------
-- Table structure for collateralinfo
-- ----------------------------
DROP TABLE IF EXISTS `collateralinfo`;
CREATE TABLE `collateralinfo` (
  `CollateralInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `LoanAccountInfoID` int(11) DEFAULT NULL,
  `CollateralValueEstimateID` int(11) DEFAULT NULL,
  `PawnType` varchar(20) DEFAULT NULL,
  `PawnName` varchar(50) DEFAULT NULL,
  `PawnTitleProof` int(30) DEFAULT NULL,
  `PawnAddress` varchar(30) DEFAULT NULL,
  `PawnSetUpDate` date DEFAULT NULL,
  `PawnRelieveDate` date DEFAULT NULL,
  `PawnValueEsti` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`CollateralInfoID`),
  KEY `FK_r_r26` (`LoanAccountInfoID`),
  KEY `FK_rr_27` (`CollateralValueEstimateID`),
  KEY `fk_rr` (`PawnTitleProof`),
  CONSTRAINT `fk_rr` FOREIGN KEY (`PawnTitleProof`) REFERENCES `proof` (`OwnershipID`),
  CONSTRAINT `FK_rr_27` FOREIGN KEY (`CollateralValueEstimateID`) REFERENCES `collateralvalueestimate` (`CollateralValueEstimateID`),
  CONSTRAINT `FK_r_r26` FOREIGN KEY (`LoanAccountInfoID`) REFERENCES `loanaccountinfo` (`LoanAccountInfoID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collateralinfo
-- ----------------------------
INSERT INTO `collateralinfo` VALUES ('2', '11', null, '四合院', '3000', '2', '北京天安门广场', null, null, null);

-- ----------------------------
-- Table structure for collateralvalueestimate
-- ----------------------------
DROP TABLE IF EXISTS `collateralvalueestimate`;
CREATE TABLE `collateralvalueestimate` (
  `CollateralValueEstimateID` int(11) NOT NULL AUTO_INCREMENT,
  `PawnType` varchar(20) DEFAULT NULL,
  `PawnAddress` varchar(30) DEFAULT NULL,
  `PawnOwner` varchar(30) DEFAULT NULL,
  `OwnerIDNo` varchar(50) DEFAULT NULL,
  `PawnValueEsti` float(8,2) DEFAULT NULL,
  `Remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CollateralValueEstimateID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collateralvalueestimate
-- ----------------------------

-- ----------------------------
-- Table structure for extractdetails
-- ----------------------------
DROP TABLE IF EXISTS `extractdetails`;
CREATE TABLE `extractdetails` (
  `ExtractDetailsID` int(11) NOT NULL AUTO_INCREMENT,
  `ApprovalNumberID` int(11) DEFAULT NULL,
  `IDNo` int(11) DEFAULT NULL,
  `ExtractionModeNumber` int(11) DEFAULT NULL,
  `WithdrawalAmount` float(8,2) DEFAULT NULL,
  `ReasonNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`ExtractDetailsID`),
  KEY `FK_r_11` (`IDNo`),
  KEY `FK_r_7` (`ApprovalNumberID`),
  KEY `FK_r_9` (`ExtractionModeNumber`),
  KEY `ww` (`ReasonNo`),
  CONSTRAINT `FK_r_11` FOREIGN KEY (`IDNo`) REFERENCES `identificationpaper` (`IDNo`),
  CONSTRAINT `FK_r_7` FOREIGN KEY (`ApprovalNumberID`) REFERENCES `extractionandapproval` (`ApprovalNumberID`),
  CONSTRAINT `FK_r_9` FOREIGN KEY (`ExtractionModeNumber`) REFERENCES `extractionmode` (`ExtractionModeNumber`),
  CONSTRAINT `ww` FOREIGN KEY (`ReasonNo`) REFERENCES `causeofextraction` (`ReasonNo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of extractdetails
-- ----------------------------
INSERT INTO `extractdetails` VALUES ('2', '2', null, null, null, null);

-- ----------------------------
-- Table structure for extractionandapproval
-- ----------------------------
DROP TABLE IF EXISTS `extractionandapproval`;
CREATE TABLE `extractionandapproval` (
  `ApprovalNumberID` int(11) NOT NULL AUTO_INCREMENT,
  `IndAccountID` int(11) DEFAULT NULL,
  `IndAccount` varchar(50) DEFAULT NULL,
  `Applicationtime` date DEFAULT NULL,
  `WorkersName` varchar(20) DEFAULT NULL,
  `bankOfDeposit` varchar(50) DEFAULT NULL,
  `payee` varchar(20) DEFAULT NULL,
  `CollectionAccount` varchar(60) DEFAULT NULL,
  `ApprovalStatus` varchar(20) DEFAULT NULL,
  `ApprovalTime` date DEFAULT NULL,
  `WithdrawalAmount` double(8,2) DEFAULT NULL,
  `exunitnum` varchar(255) DEFAULT NULL,
  `exunitname` varchar(255) DEFAULT NULL,
  `exdoctype` varchar(255) DEFAULT NULL,
  `exidnum` varchar(255) DEFAULT NULL,
  `indaccstatus` varchar(255) DEFAULT NULL,
  `exsex` varchar(255) DEFAULT NULL,
  `exage` varchar(255) DEFAULT NULL,
  `exmodel` varchar(255) DEFAULT NULL,
  `exphone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ApprovalNumberID`),
  KEY `FK_r_8` (`IndAccountID`),
  CONSTRAINT `FK_r_8` FOREIGN KEY (`IndAccountID`) REFERENCES `indaccountinfo` (`IndAccountID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of extractionandapproval
-- ----------------------------
INSERT INTO `extractionandapproval` VALUES ('2', '15', null, '2018-09-01', '张一', '中国银行', '张一', '88899878979879', '未审批', null, '3000.00', '4', 'AAA软件教育', '身份证', '410025199711014925', '正常', '女', '21', '转账提取', '13569541609');

-- ----------------------------
-- Table structure for extractionmode
-- ----------------------------
DROP TABLE IF EXISTS `extractionmode`;
CREATE TABLE `extractionmode` (
  `ExtractionModeNumber` int(11) NOT NULL AUTO_INCREMENT,
  `ExtractionModeDescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ExtractionModeNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人全部提取\r\n个人部分提取\r\n夫妻全部提取\r\n夫妻部分提取';

-- ----------------------------
-- Records of extractionmode
-- ----------------------------

-- ----------------------------
-- Table structure for extractionrecord
-- ----------------------------
DROP TABLE IF EXISTS `extractionrecord`;
CREATE TABLE `extractionrecord` (
  `ExtractionRecordID` int(11) NOT NULL AUTO_INCREMENT,
  `ExtractionUnit` varchar(30) DEFAULT NULL,
  `ExtractionAccount` varchar(30) DEFAULT NULL,
  `WithdrawalAmount` float(8,2) DEFAULT NULL,
  `ExtractionDate` date DEFAULT NULL,
  `LoanDate` date DEFAULT NULL,
  `ExtractDetails` int(11) DEFAULT NULL,
  `Receptionist` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ExtractionRecordID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of extractionrecord
-- ----------------------------

-- ----------------------------
-- Table structure for flupay
-- ----------------------------
DROP TABLE IF EXISTS `flupay`;
CREATE TABLE `flupay` (
  `FluPayid` int(11) NOT NULL AUTO_INCREMENT,
  `UtinAccountID` int(11) DEFAULT NULL,
  `UtinName` varchar(255) DEFAULT NULL,
  `FluPayprove` varchar(255) DEFAULT NULL,
  `ifelseFP` varchar(255) DEFAULT '否',
  PRIMARY KEY (`FluPayid`),
  KEY `fk_fp_utinid` (`UtinAccountID`),
  CONSTRAINT `fk_fp_utinid` FOREIGN KEY (`UtinAccountID`) REFERENCES `utinaccountinfo` (`UtinAccountID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flupay
-- ----------------------------

-- ----------------------------
-- Table structure for fundtranreco
-- ----------------------------
DROP TABLE IF EXISTS `fundtranreco`;
CREATE TABLE `fundtranreco` (
  `TranRecoID` int(11) NOT NULL AUTO_INCREMENT,
  `HostAccount` varchar(50) DEFAULT NULL,
  `SeconAccount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TranRecoID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fundtranreco
-- ----------------------------

-- ----------------------------
-- Table structure for fush
-- ----------------------------
DROP TABLE IF EXISTS `fush`;
CREATE TABLE `fush` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrId` int(11) NOT NULL,
  `iphone` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `454` (`borrId`),
  CONSTRAINT `454` FOREIGN KEY (`borrId`) REFERENCES `borrowmoneyagreement` (`BorrowMoneyAgreementID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fush
-- ----------------------------
INSERT INTO `fush` VALUES ('2', '6', '13569541609', '6217002710000684874', '冻结');

-- ----------------------------
-- Table structure for guaranteemode
-- ----------------------------
DROP TABLE IF EXISTS `guaranteemode`;
CREATE TABLE `guaranteemode` (
  `GuaranteeModeID` int(11) NOT NULL AUTO_INCREMENT,
  `SecurityModeDes` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`GuaranteeModeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='拟购买住房抵押\r\n保证人担保\r\n其他房产抵押';

-- ----------------------------
-- Records of guaranteemode
-- ----------------------------
INSERT INTO `guaranteemode` VALUES ('1', '拟购房抵押');
INSERT INTO `guaranteemode` VALUES ('2', '其他房产抵押');
INSERT INTO `guaranteemode` VALUES ('3', '担保人担保');

-- ----------------------------
-- Table structure for guarantorinfo
-- ----------------------------
DROP TABLE IF EXISTS `guarantorinfo`;
CREATE TABLE `guarantorinfo` (
  `GuarantorInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `GuaraInfoEstID` int(11) DEFAULT NULL,
  `LoanAccountInfoID` int(11) DEFAULT NULL,
  `GuarantorName` varchar(50) DEFAULT NULL,
  `GuarantorIDNo` varchar(50) DEFAULT NULL,
  `GuarantorAddress` varchar(50) DEFAULT NULL,
  `GuarantorPhone` varchar(50) DEFAULT NULL,
  `GuarantorUtin` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`GuarantorInfoID`),
  KEY `FK_r_23` (`LoanAccountInfoID`),
  KEY `FK_r_29` (`GuaraInfoEstID`),
  CONSTRAINT `FK_r_23` FOREIGN KEY (`LoanAccountInfoID`) REFERENCES `loanaccountinfo` (`LoanAccountInfoID`),
  CONSTRAINT `FK_r_29` FOREIGN KEY (`GuaraInfoEstID`) REFERENCES `guarantorinfoestimate` (`GuaraInfoEstID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guarantorinfo
-- ----------------------------
INSERT INTO `guarantorinfo` VALUES ('3', null, '10', '马云', '110025199711014927', '杭州', '500000', 'Alibaba');

-- ----------------------------
-- Table structure for guarantorinfoestimate
-- ----------------------------
DROP TABLE IF EXISTS `guarantorinfoestimate`;
CREATE TABLE `guarantorinfoestimate` (
  `GuaraInfoEstID` int(11) NOT NULL AUTO_INCREMENT,
  `GuarantorUtin` varchar(100) DEFAULT NULL,
  `GuarantorPost` char(10) DEFAULT NULL,
  `GuarantorYearIncome` float(8,2) DEFAULT NULL,
  `RepaymentAbility` int(11) DEFAULT NULL,
  `GuarantorFundAssess` float(8,2) DEFAULT NULL,
  `Remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`GuaraInfoEstID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guarantorinfoestimate
-- ----------------------------

-- ----------------------------
-- Table structure for identificationpaper
-- ----------------------------
DROP TABLE IF EXISTS `identificationpaper`;
CREATE TABLE `identificationpaper` (
  `IDNo` int(11) NOT NULL AUTO_INCREMENT,
  `IDCard` varchar(50) DEFAULT NULL,
  `OriginalIDCard` varchar(50) DEFAULT NULL,
  `MarriageCertificate` varchar(50) DEFAULT NULL,
  `DomicileCertificate` varchar(50) DEFAULT NULL,
  `OperatorIDCard` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identificationpaper
-- ----------------------------

-- ----------------------------
-- Table structure for indaccountinfo
-- ----------------------------
DROP TABLE IF EXISTS `indaccountinfo`;
CREATE TABLE `indaccountinfo` (
  `IndAccountID` int(11) NOT NULL AUTO_INCREMENT,
  `IndID` int(11) DEFAULT NULL,
  `UtinAccountID` int(11) DEFAULT NULL,
  `IndDepositRadices` float(8,2) DEFAULT NULL,
  `IndDepositRatio` float(8,3) DEFAULT NULL,
  `IndOpenDate` date DEFAULT NULL,
  `LastChangeRem` float(8,2) DEFAULT NULL,
  `ThisPayRem` float(8,2) DEFAULT NULL,
  `PresentSumRem` float(8,2) DEFAULT NULL,
  `UsableRem` float(8,2) DEFAULT NULL,
  `PeMonthDep` float(8,2) DEFAULT NULL,
  `UtinMonthDep` float(8,2) DEFAULT NULL,
  `BankSaAccount` varchar(50) DEFAULT NULL,
  `BankOpenAccount` varchar(50) DEFAULT NULL,
  `IndStatus` varchar(10) DEFAULT NULL,
  `LoginAccount` varchar(50) DEFAULT NULL,
  `LoginPass` varchar(30) DEFAULT NULL,
  `TrueName` varchar(255) DEFAULT NULL,
  `IDNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IndAccountID`),
  KEY `FK_Relationship_3` (`IndID`),
  KEY `FK_r_3` (`UtinAccountID`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`IndID`) REFERENCES `indinfo` (`IndInfoID`),
  CONSTRAINT `FK_r_3` FOREIGN KEY (`UtinAccountID`) REFERENCES `utinaccountinfo` (`UtinAccountID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indaccountinfo
-- ----------------------------
INSERT INTO `indaccountinfo` VALUES ('15', '22', '4', '15000.00', '0.120', null, '0.00', '0.00', '28800.00', '28800.00', null, null, '54562351231412', '中国银行', '正常', '410025199711014925', '014925', '张一', '410025199711014925');
INSERT INTO `indaccountinfo` VALUES ('16', '23', '4', '15000.00', '0.120', null, '0.00', '0.00', '28800.00', '28800.00', null, null, '54562351231412', '中国银行', '正常', '410025199711014927', '014927', '王二', '410025199711014927');
INSERT INTO `indaccountinfo` VALUES ('17', '24', '4', '15000.00', '0.120', null, '0.00', '0.00', '28800.00', '28800.00', null, null, '54562351231412', '中国银行', '正常', '410025199711014922', '014922', '陈三', '410025199711014922');
INSERT INTO `indaccountinfo` VALUES ('18', '25', '4', '15000.00', '0.120', null, '0.00', '0.00', '28800.00', '28800.00', null, null, '54562351231412', '中国银行', '封存', '410025199711114922', '114922', '李四', '410025199711114922');
INSERT INTO `indaccountinfo` VALUES ('19', '26', '4', '15000.00', '0.120', null, '0.00', '0.00', '28800.00', '28800.00', null, null, '54562351231413', '中国银行', '正常', '410025199711114912', '114912', '马五', '410025199711114912');
INSERT INTO `indaccountinfo` VALUES ('20', '27', '4', '20000.00', '0.120', null, '0.00', '0.00', '38400.00', '38400.00', null, null, '54562351231413', '中国银行', '封存', '41022219980710983X', '10983X', '刘六', '41022219980710983X');

-- ----------------------------
-- Table structure for indinfo
-- ----------------------------
DROP TABLE IF EXISTS `indinfo`;
CREATE TABLE `indinfo` (
  `IndInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `IndAccount` varchar(50) DEFAULT NULL,
  `TrueName` varchar(50) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `FixedPhone` varchar(50) DEFAULT NULL,
  `PhoneNumber` varchar(50) DEFAULT NULL,
  `ExtractCause` varchar(30) DEFAULT NULL,
  `IDNumber` varchar(50) DEFAULT NULL,
  `WedlockStatus` varchar(50) DEFAULT NULL,
  `Duties` varchar(50) DEFAULT NULL,
  `FamilyAddress` varchar(50) DEFAULT NULL,
  `FamilyMonthIncome` int(11) DEFAULT NULL,
  `UtinAccount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IndInfoID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indinfo
-- ----------------------------
INSERT INTO `indinfo` VALUES ('22', null, '张一', '女', '6556632', '13867894567', null, '410025199711014925', '未婚', '经理', '河南', '5000', null);
INSERT INTO `indinfo` VALUES ('23', null, '王二', '女', '6556632', '13867894567', null, '410025199711014927', '未婚', '经理', '河南', '5000', null);
INSERT INTO `indinfo` VALUES ('24', null, '陈三', '女', '6556632', '13867894567', null, '410025199711014922', '未婚', '经理', '河南', '5000', null);
INSERT INTO `indinfo` VALUES ('25', null, '李四', '女', '6556632', '13867894567', null, '410025199711114922', '未婚', '经理', '河南', '5000', null);
INSERT INTO `indinfo` VALUES ('26', null, '马五', '男', '6556632', '13867894567', null, '410025199711114912', '未婚', '经理', '河南', '5000', null);
INSERT INTO `indinfo` VALUES ('27', null, '刘六', '男', '6666666', '13569541609', null, '41022219980710983X', '未婚', '董事长', '河南', '100000', null);

-- ----------------------------
-- Table structure for loanaccountinfo
-- ----------------------------
DROP TABLE IF EXISTS `loanaccountinfo`;
CREATE TABLE `loanaccountinfo` (
  `LoanAccountInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `LoanDisbur` float DEFAULT NULL,
  `LoanDate` date DEFAULT NULL,
  `loanRate` float DEFAULT NULL,
  `LoanPeriod` int(11) DEFAULT NULL,
  `CurrentShouldMoney` float DEFAULT NULL,
  `CurrentPlan` varchar(50) DEFAULT NULL,
  `TotalInterestRecovered` float DEFAULT NULL,
  `GuaranteeMode` varchar(100) DEFAULT NULL,
  `Remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`LoanAccountInfoID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loanaccountinfo
-- ----------------------------
INSERT INTO `loanaccountinfo` VALUES ('9', '50', null, '2.75', '12', null, null, null, '', '9');
INSERT INTO `loanaccountinfo` VALUES ('10', null, null, null, null, null, null, null, null, '10');
INSERT INTO `loanaccountinfo` VALUES ('11', null, null, null, null, null, null, null, null, '11');
INSERT INTO `loanaccountinfo` VALUES ('12', null, null, null, null, null, null, null, null, '12');
INSERT INTO `loanaccountinfo` VALUES ('13', null, null, null, null, null, null, null, '重复贷款', '13');

-- ----------------------------
-- Table structure for loanapplication
-- ----------------------------
DROP TABLE IF EXISTS `loanapplication`;
CREATE TABLE `loanapplication` (
  `LoanApplicationID` int(11) NOT NULL AUTO_INCREMENT,
  `PurchaseContractID` int(11) DEFAULT NULL,
  `UseOfFundsID` int(11) DEFAULT NULL,
  `GuaranteeModeID` int(11) DEFAULT NULL,
  `CoborrowerID` int(11) DEFAULT NULL,
  `NameOfBorrower` varchar(30) DEFAULT NULL,
  `BorrowerIDNumber` varchar(50) DEFAULT NULL,
  `BorrowersUnit` varchar(50) DEFAULT NULL,
  `BorrowerPhone` varchar(50) DEFAULT NULL,
  `IndAccount` varchar(50) DEFAULT NULL,
  `UnitAddress` varchar(100) DEFAULT NULL,
  `BorrowerMonthMoney` float(8,2) DEFAULT NULL,
  `BorrowingBalance` float(8,2) DEFAULT NULL,
  `LentYearsNumber` int(11) DEFAULT NULL,
  `AnnualRate` float DEFAULT NULL,
  `Remarks` varchar(100) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LoanApplicationID`),
  KEY `FK_Reference_42` (`CoborrowerID`),
  KEY `FK_Reference_43` (`GuaranteeModeID`),
  KEY `FK_r_18` (`UseOfFundsID`),
  KEY `FK_r_24` (`PurchaseContractID`),
  CONSTRAINT `FK_Reference_42` FOREIGN KEY (`CoborrowerID`) REFERENCES `coborrower` (`CoborrowerID`),
  CONSTRAINT `FK_Reference_43` FOREIGN KEY (`GuaranteeModeID`) REFERENCES `guaranteemode` (`GuaranteeModeID`),
  CONSTRAINT `FK_r_18` FOREIGN KEY (`UseOfFundsID`) REFERENCES `useoffunds` (`UseOfFundsID`),
  CONSTRAINT `FK_r_24` FOREIGN KEY (`PurchaseContractID`) REFERENCES `purchasecontract` (`PurchaseContractID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loanapplication
-- ----------------------------
INSERT INTO `loanapplication` VALUES ('9', '9', '2', '1', null, '张一', '410025199711014925', 'AAA软件教育', '13569541609', '15', '等额本息还款', '30000.00', '50.00', '12', '2.75', '首套房', '借款合同已签订');
INSERT INTO `loanapplication` VALUES ('10', '10', '2', '3', '2', '王二', '410025199711014927', 'AAA软件教育', '13569541609', '16', '等额本息还款', '20000.00', '70.00', '12', '2.75', '首套房', '未审批');
INSERT INTO `loanapplication` VALUES ('11', '11', '2', '2', null, '陈三', '410025199711014922', 'AAA软件教育', '13569541609', '17', '等额本息还款', '200000.00', '30.00', '12', '2.75', '首套房', '未审批');
INSERT INTO `loanapplication` VALUES ('12', '12', '2', '1', null, '马五', '410025199711114912', 'AAA软件教育', '13569541609', '19', '等额本息还款', '20000.00', '30.00', '12', '2.75', '首套房', '未审批');
INSERT INTO `loanapplication` VALUES ('13', '13', '2', '1', null, '陈三', '410025199711014922', 'AAA软件教育', '13569541609', '17', '等额本息还款', '10000.00', '40.00', '12', '2.75', '首套房', '申请驳回');

-- ----------------------------
-- Table structure for loanbook
-- ----------------------------
DROP TABLE IF EXISTS `loanbook`;
CREATE TABLE `loanbook` (
  `LoanBookID` int(11) NOT NULL AUTO_INCREMENT,
  `LoanAccount` varchar(50) DEFAULT NULL,
  `Lender` varchar(30) DEFAULT NULL,
  `ValueOfLoan` float(8,2) DEFAULT NULL,
  `LoanDate` date DEFAULT NULL,
  `LoanStatus` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`LoanBookID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='贷款状态：已还清  未还清';

-- ----------------------------
-- Records of loanbook
-- ----------------------------
INSERT INTO `loanbook` VALUES ('6', '15', '张一', '50.00', '2018-09-01', '未还清');

-- ----------------------------
-- Table structure for loanfinal
-- ----------------------------
DROP TABLE IF EXISTS `loanfinal`;
CREATE TABLE `loanfinal` (
  `LoanFinalID` int(11) NOT NULL AUTO_INCREMENT,
  `BorrowMoneyAgreementID` int(11) DEFAULT NULL,
  `LoanApplicationID` int(11) DEFAULT NULL,
  `InfEvaluationTable` int(11) DEFAULT NULL,
  PRIMARY KEY (`LoanFinalID`),
  KEY `FK_Reference_38` (`LoanApplicationID`),
  KEY `FK_r_31` (`BorrowMoneyAgreementID`),
  CONSTRAINT `FK_Reference_38` FOREIGN KEY (`LoanApplicationID`) REFERENCES `loanapplication` (`LoanApplicationID`),
  CONSTRAINT `FK_r_31` FOREIGN KEY (`BorrowMoneyAgreementID`) REFERENCES `borrowmoneyagreement` (`BorrowMoneyAgreementID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loanfinal
-- ----------------------------
INSERT INTO `loanfinal` VALUES ('6', '6', '9', '9');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `repayId` int(11) DEFAULT NULL,
  `money` varchar(255) DEFAULT NULL,
  `riqi` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `fushId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `weq` (`repayId`),
  KEY `123` (`fushId`),
  CONSTRAINT `123` FOREIGN KEY (`fushId`) REFERENCES `fush` (`id`),
  CONSTRAINT `weq` FOREIGN KEY (`repayId`) REFERENCES `repaymentplandetails` (`RepaymentPlanDetailsiID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('21', '52', '33396.18', '2018/09/20', '失败', '余额不足。', '2');

-- ----------------------------
-- Table structure for materialproof
-- ----------------------------
DROP TABLE IF EXISTS `materialproof`;
CREATE TABLE `materialproof` (
  `MaterialProofID` int(11) NOT NULL AUTO_INCREMENT,
  `MaterialTypeID` int(11) DEFAULT NULL,
  `ExtractDetailsID` int(11) DEFAULT NULL,
  `Mat_MaterialTypeID` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaterialProofID`),
  KEY `FK_Reference_50` (`Mat_MaterialTypeID`),
  KEY `FK_r_13` (`ExtractDetailsID`),
  KEY `FK_r_14` (`MaterialTypeID`),
  CONSTRAINT `FK_Reference_50` FOREIGN KEY (`Mat_MaterialTypeID`) REFERENCES `materialtype` (`MaterialTypeID`),
  CONSTRAINT `FK_r_13` FOREIGN KEY (`ExtractDetailsID`) REFERENCES `extractdetails` (`ExtractDetailsID`),
  CONSTRAINT `FK_r_14` FOREIGN KEY (`MaterialTypeID`) REFERENCES `materialtype` (`MaterialTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of materialproof
-- ----------------------------
INSERT INTO `materialproof` VALUES ('2', '2', '2', null);

-- ----------------------------
-- Table structure for materialtype
-- ----------------------------
DROP TABLE IF EXISTS `materialtype`;
CREATE TABLE `materialtype` (
  `MaterialTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `MaterialProofID` int(11) DEFAULT NULL,
  `PurchaseContractID` int(11) DEFAULT NULL,
  `TypeSpecification` varchar(50) DEFAULT NULL,
  `piID` int(11) DEFAULT NULL,
  `DeathCertificateID` int(11) DEFAULT NULL,
  `RetireID` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaterialTypeID`),
  KEY `FK_r_15` (`MaterialProofID`),
  KEY `fk_ww` (`DeathCertificateID`),
  KEY `fk_w1` (`piID`),
  KEY `fk_w22` (`RetireID`),
  CONSTRAINT `FK_r_15` FOREIGN KEY (`MaterialProofID`) REFERENCES `materialproof` (`MaterialProofID`),
  CONSTRAINT `fk_w1` FOREIGN KEY (`piID`) REFERENCES `purinfo` (`piID`),
  CONSTRAINT `fk_w22` FOREIGN KEY (`RetireID`) REFERENCES `retireti` (`RetireID`),
  CONSTRAINT `fk_ww` FOREIGN KEY (`DeathCertificateID`) REFERENCES `proofofdeath` (`DeathCertificateID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品房买卖合同\r\n  离休\r\n  死亡\r\n偿还贷款本息\r\n';

-- ----------------------------
-- Records of materialtype
-- ----------------------------
INSERT INTO `materialtype` VALUES ('2', null, null, null, '2', null, null);

-- ----------------------------
-- Table structure for mpfacentrestat
-- ----------------------------
DROP TABLE IF EXISTS `mpfacentrestat`;
CREATE TABLE `mpfacentrestat` (
  `MPFACentreStatID` int(11) NOT NULL AUTO_INCREMENT,
  `AggregateSumStat` float(8,2) DEFAULT NULL,
  `WithdrawalSumStat` float(8,2) DEFAULT NULL,
  `LoanAmountStat` float(8,2) DEFAULT NULL,
  `RecoveryLoanStat` float(8,2) DEFAULT NULL,
  `UnitAccountOpenStat` int(11) DEFAULT NULL,
  `IndividualAccountStat` int(11) DEFAULT NULL,
  `StatisticalTime` date DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`MPFACentreStatID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='状态：冻结  正常';

-- ----------------------------
-- Records of mpfacentrestat
-- ----------------------------
INSERT INTO `mpfacentrestat` VALUES ('21', '22800.00', null, null, null, null, null, '2018-05-01', null);
INSERT INTO `mpfacentrestat` VALUES ('22', '45600.00', null, null, null, null, null, '2018-06-01', null);
INSERT INTO `mpfacentrestat` VALUES ('23', '68400.00', null, null, null, null, null, '2018-06-01', null);
INSERT INTO `mpfacentrestat` VALUES ('24', '45600.00', null, null, null, null, null, '2018-07-01', null);
INSERT INTO `mpfacentrestat` VALUES ('25', null, null, '50.00', null, null, null, '2018-09-01', null);
INSERT INTO `mpfacentrestat` VALUES ('26', null, null, null, '42813.00', null, null, '2018-09-01', null);

-- ----------------------------
-- Table structure for overduerepayment
-- ----------------------------
DROP TABLE IF EXISTS `overduerepayment`;
CREATE TABLE `overduerepayment` (
  `OverdueRepaymentID` int(11) NOT NULL AUTO_INCREMENT,
  `ReturnedPriInt` float(8,2) DEFAULT NULL,
  `DefaultInterest` float(8,2) DEFAULT NULL,
  `RepaymentDate` date DEFAULT NULL,
  PRIMARY KEY (`OverdueRepaymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of overduerepayment
-- ----------------------------

-- ----------------------------
-- Table structure for personalmanagement
-- ----------------------------
DROP TABLE IF EXISTS `personalmanagement`;
CREATE TABLE `personalmanagement` (
  `PersonalManagementID` int(11) NOT NULL AUTO_INCREMENT,
  `EmployeeName` varchar(30) DEFAULT NULL,
  `EntryTime` date DEFAULT NULL,
  `EmployeeSex` varchar(50) DEFAULT NULL,
  `EmployeeAccount` int(11) DEFAULT NULL,
  `EmployeePass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PersonalManagementID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personalmanagement
-- ----------------------------

-- ----------------------------
-- Table structure for powers
-- ----------------------------
DROP TABLE IF EXISTS `powers`;
CREATE TABLE `powers` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `purl` varchar(255) DEFAULT NULL,
  `pType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of powers
-- ----------------------------
INSERT INTO `powers` VALUES ('1', '功能管理', 'LDL/addFunction.jsp', '权限管理');
INSERT INTO `powers` VALUES ('2', '角色管理', 'LDL/addRole.jsp', '权限管理');
INSERT INTO `powers` VALUES ('3', '功能分配', 'LDL/functionAllot.jsp', '权限管理');
INSERT INTO `powers` VALUES ('4', '员工管理', 'LDL/addUsers.jsp', '员工管理');
INSERT INTO `powers` VALUES ('36', '单位开户', 'LDL/addUnit.jsp', '单位业务');
INSERT INTO `powers` VALUES ('37', '单位管理', 'LDL/baseAlter.jsp', '单位业务');
INSERT INTO `powers` VALUES ('38', '开户审批', 'LDL/unitCheck.jsp', '单位业务');
INSERT INTO `powers` VALUES ('39', '员工开户', 'LDL/showUnit.jsp', '单位业务');
INSERT INTO `powers` VALUES ('40', '汇缴办理', '../ssw/RemPro.jsp', '汇缴提取');
INSERT INTO `powers` VALUES ('41', '提取申请', '../ssw/extract.jsp', '个人业务');
INSERT INTO `powers` VALUES ('42', '提取审批', '../ssw/examine.jsp', '个人业务');
INSERT INTO `powers` VALUES ('43', '汇缴清册', '../ssw/RemitDetail.jsp', '汇缴提取');
INSERT INTO `powers` VALUES ('44', '补缴办理', '../ssw/supple.jsp', '汇缴提取');
INSERT INTO `powers` VALUES ('45', '贷款申请', 'hcq/LoanApplication.jsp', '信贷业务');
INSERT INTO `powers` VALUES ('46', '信用评估', 'hcq/showlendApproval.action', '信贷业务');
INSERT INTO `powers` VALUES ('47', '价值评估', 'assureAssess.action', '信贷业务');
INSERT INTO `powers` VALUES ('48', '贷款审核', 'review.action', '信贷业务');
INSERT INTO `powers` VALUES ('49', '签订借贷合同', 'hcq/LoanPact.jsp', '信贷业务');
INSERT INTO `powers` VALUES ('50', '按揭还款', 'hcq/return_loan.jsp', '还款业务');
INSERT INTO `powers` VALUES ('51', '冲还贷业务办理', 'hcq/push_Loan.jsp', '冲贷业务');
INSERT INTO `powers` VALUES ('53', '领结清单', 'hcq/Refund.jsp', '还款业务');
INSERT INTO `powers` VALUES ('54', '提前还款', 'hcq/before_return_loan.jsp', '还款业务');
INSERT INTO `powers` VALUES ('55', '定时缴费', '../ssw/timer.jsp', '汇缴提取');
INSERT INTO `powers` VALUES ('56', '提前还款审核', 'check_return.action', '还款业务');
INSERT INTO `powers` VALUES ('57', '冲还贷信息管理', 'getPart.action', '冲贷业务');
INSERT INTO `powers` VALUES ('58', '单位信息', 'LDL/UnitSup.jsp', '信息管理');
INSERT INTO `powers` VALUES ('59', '个人信息', 'LDL/EmpSup.jsp', '信息管理');
INSERT INTO `powers` VALUES ('60', '提前还款申请进度', 'hcq/find_beforeLoan.jsp', '进度查询');
INSERT INTO `powers` VALUES ('61', '公积金提取进度', '../ssw/newabs.jsp', '进度查询');
INSERT INTO `powers` VALUES ('62', '公积金贷款进度', 'hcq/find_loan.jsp', '进度查询');
INSERT INTO `powers` VALUES ('63', '未完成的单位开户进度', 'hcq/find_register.jsp', '未完成的进度查询');
INSERT INTO `powers` VALUES ('65', '冲还贷日志', 'getAllLog.action', '冲贷业务');
INSERT INTO `powers` VALUES ('66', '账户转移', 'LDL/EmpUtine.jsp', '个人业务');

-- ----------------------------
-- Table structure for proof
-- ----------------------------
DROP TABLE IF EXISTS `proof`;
CREATE TABLE `proof` (
  `OwnershipID` int(255) NOT NULL AUTO_INCREMENT,
  `Person` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `issued_name` varchar(255) DEFAULT NULL,
  `issues_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`OwnershipID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of proof
-- ----------------------------
INSERT INTO `proof` VALUES ('2', '陈三', '北京天安门广场', '北京市房产登记处', '2018-06-03 00:00:00');

-- ----------------------------
-- Table structure for proofofdeath
-- ----------------------------
DROP TABLE IF EXISTS `proofofdeath`;
CREATE TABLE `proofofdeath` (
  `MaterialTypeID` int(11) DEFAULT NULL,
  `DeathCertificateID` int(11) NOT NULL AUTO_INCREMENT,
  `MyName` varchar(50) DEFAULT NULL,
  `IDNo` varchar(50) DEFAULT NULL,
  `PlaceOfDomicile` varchar(50) DEFAULT NULL,
  `CauseOfDeath` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DeathCertificateID`),
  KEY `FK_r_39` (`MaterialTypeID`),
  CONSTRAINT `FK_r_39` FOREIGN KEY (`MaterialTypeID`) REFERENCES `materialtype` (`MaterialTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of proofofdeath
-- ----------------------------

-- ----------------------------
-- Table structure for purchasecontract
-- ----------------------------
DROP TABLE IF EXISTS `purchasecontract`;
CREATE TABLE `purchasecontract` (
  `PurchaseContractID` int(11) NOT NULL AUTO_INCREMENT,
  `PurchasedHInfoID` int(11) DEFAULT NULL,
  `MaterialTypeID` int(11) DEFAULT NULL,
  `SalesPersonName` varchar(30) DEFAULT NULL,
  `HomeBuyersName` varchar(30) DEFAULT NULL,
  `SalesPersonPhone` varchar(100) DEFAULT NULL,
  `HomeBuyersPhone` varchar(100) DEFAULT NULL,
  `TreatycCntents` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`PurchaseContractID`),
  KEY `FK_Reference_48` (`MaterialTypeID`),
  KEY `FK_r_21` (`PurchasedHInfoID`),
  CONSTRAINT `FK_Reference_48` FOREIGN KEY (`MaterialTypeID`) REFERENCES `materialtype` (`MaterialTypeID`),
  CONSTRAINT `FK_r_21` FOREIGN KEY (`PurchasedHInfoID`) REFERENCES `purchasedhinfo` (`PurchasedHInfoID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchasecontract
-- ----------------------------
INSERT INTO `purchasecontract` VALUES ('9', '9', null, '张一', '张一', '410654898798254', '410025199711014925', '50');
INSERT INTO `purchasecontract` VALUES ('10', '10', null, '华腾', '王二', '89556456421', '410025199711014927', '430');
INSERT INTO `purchasecontract` VALUES ('11', '11', null, '华腾', '陈三', '6217002710000684874', '410025199711014922', '70');
INSERT INTO `purchasecontract` VALUES ('12', '12', null, '华腾', '马五', '6217002710000684874', '410025199711114912', '5');
INSERT INTO `purchasecontract` VALUES ('13', '13', null, '华腾', '陈三', '6217002710000684874', '410025199711014922', '5');

-- ----------------------------
-- Table structure for purchasedhinfo
-- ----------------------------
DROP TABLE IF EXISTS `purchasedhinfo`;
CREATE TABLE `purchasedhinfo` (
  `PurchasedHInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `HousingType` varchar(50) DEFAULT NULL,
  `HousingPosition` varchar(50) DEFAULT NULL,
  `FloorSpace` varchar(50) DEFAULT NULL,
  `SellingPrice` float DEFAULT NULL,
  PRIMARY KEY (`PurchasedHInfoID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='房屋类型：商品房  经济房  二手房';

-- ----------------------------
-- Records of purchasedhinfo
-- ----------------------------
INSERT INTO `purchasedhinfo` VALUES ('9', '商品房', '北京天安门', '500', '100');
INSERT INTO `purchasedhinfo` VALUES ('10', '商品房', '上海市中心', '300', '500');
INSERT INTO `purchasedhinfo` VALUES ('11', '商品房', '郑州二七广场', '500', '100');
INSERT INTO `purchasedhinfo` VALUES ('12', '四合院', '北京天安门', '3000', '10');
INSERT INTO `purchasedhinfo` VALUES ('13', '商品房', '北京', '300', '10');

-- ----------------------------
-- Table structure for purinfo
-- ----------------------------
DROP TABLE IF EXISTS `purinfo`;
CREATE TABLE `purinfo` (
  `piID` int(11) NOT NULL AUTO_INCREMENT,
  `puType` varchar(255) DEFAULT NULL,
  `PuAddress` varchar(255) DEFAULT NULL,
  `Pumoney` varchar(255) DEFAULT NULL,
  `puText` varchar(255) DEFAULT NULL,
  `shphone` varchar(255) DEFAULT NULL,
  `shaddress` varchar(255) DEFAULT NULL,
  `shutin` varchar(255) DEFAULT NULL,
  `shidnum` varchar(255) DEFAULT NULL,
  `hbname` varchar(255) DEFAULT NULL,
  `recnum` varchar(255) DEFAULT NULL,
  `houcs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`piID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purinfo
-- ----------------------------
INSERT INTO `purinfo` VALUES ('2', '', '1000', '1000', '1', '156989784987', '北京天安门广场', '售房单位', '410025199711014925', '张一', '北京天安门广场', '已住');

-- ----------------------------
-- Table structure for remittancedetail
-- ----------------------------
DROP TABLE IF EXISTS `remittancedetail`;
CREATE TABLE `remittancedetail` (
  `DepositInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `UtinAccountID` int(11) DEFAULT NULL,
  `IndAccountID` varchar(10) DEFAULT NULL,
  `UtinAccount` varchar(50) DEFAULT NULL,
  `UtinPayinMoney` float(8,2) DEFAULT NULL,
  `IndAccount` varchar(50) DEFAULT NULL,
  `IndPayinMoney` float(8,2) DEFAULT NULL,
  `PayinSumMoney` float(8,2) DEFAULT NULL,
  `PayinDate` date DEFAULT NULL,
  `Operator` varchar(30) DEFAULT NULL,
  `Receptionist` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DepositInfoID`),
  KEY `FK_r_4` (`UtinAccountID`),
  CONSTRAINT `FK_r_4` FOREIGN KEY (`UtinAccountID`) REFERENCES `utinaccountinfo` (`UtinAccountID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remittancedetail
-- ----------------------------
INSERT INTO `remittancedetail` VALUES ('25', '4', '15', 'AAA软件教育', null, '15', null, '3600.00', '2018-05-01', null, null);
INSERT INTO `remittancedetail` VALUES ('26', '4', '16', 'AAA软件教育', null, '16', null, '3600.00', '2018-05-01', null, null);
INSERT INTO `remittancedetail` VALUES ('27', '4', '17', 'AAA软件教育', null, '17', null, '3600.00', '2018-05-01', null, null);
INSERT INTO `remittancedetail` VALUES ('28', '4', '18', 'AAA软件教育', null, '18', null, '3600.00', '2018-05-01', null, null);
INSERT INTO `remittancedetail` VALUES ('29', '4', '19', 'AAA软件教育', null, '19', null, '3600.00', '2018-05-01', null, null);
INSERT INTO `remittancedetail` VALUES ('30', '4', '20', 'AAA软件教育', null, '20', null, '4800.00', '2018-05-01', null, null);
INSERT INTO `remittancedetail` VALUES ('31', '4', '15', 'AAA软件教育', null, '15', null, '7200.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('32', '4', '16', 'AAA软件教育', null, '16', null, '7200.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('33', '4', '17', 'AAA软件教育', null, '17', null, '7200.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('34', '4', '18', 'AAA软件教育', null, '18', null, '7200.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('35', '4', '19', 'AAA软件教育', null, '19', null, '7200.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('36', '4', '20', 'AAA软件教育', null, '20', null, '9600.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('37', '4', '15', 'AAA软件教育', null, '15', null, '10800.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('38', '4', '16', 'AAA软件教育', null, '16', null, '10800.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('39', '4', '17', 'AAA软件教育', null, '17', null, '10800.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('40', '4', '18', 'AAA软件教育', null, '18', null, '10800.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('41', '4', '19', 'AAA软件教育', null, '19', null, '10800.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('42', '4', '20', 'AAA软件教育', null, '20', null, '14400.00', '2018-06-01', null, null);
INSERT INTO `remittancedetail` VALUES ('43', '4', '15', 'AAA软件教育', null, '15', null, '7200.00', '2018-07-01', null, null);
INSERT INTO `remittancedetail` VALUES ('44', '4', '16', 'AAA软件教育', null, '16', null, '7200.00', '2018-07-01', null, null);
INSERT INTO `remittancedetail` VALUES ('45', '4', '17', 'AAA软件教育', null, '17', null, '7200.00', '2018-07-01', null, null);
INSERT INTO `remittancedetail` VALUES ('46', '4', '18', 'AAA软件教育', null, '18', null, '7200.00', '2018-07-01', null, null);
INSERT INTO `remittancedetail` VALUES ('47', '4', '19', 'AAA软件教育', null, '19', null, '7200.00', '2018-07-01', null, null);
INSERT INTO `remittancedetail` VALUES ('48', '4', '20', 'AAA软件教育', null, '20', null, '9600.00', '2018-07-01', null, null);

-- ----------------------------
-- Table structure for repaymentplandetails
-- ----------------------------
DROP TABLE IF EXISTS `repaymentplandetails`;
CREATE TABLE `repaymentplandetails` (
  `RepaymentPlanDetailsiID` int(11) NOT NULL AUTO_INCREMENT,
  `OverdueRepaymentID` int(11) DEFAULT NULL,
  `ModeOfRepaymentSelect` varchar(20) DEFAULT NULL,
  `CurrentReturnedCorpus` float(8,2) DEFAULT NULL,
  `CurrentReturnedInterest` float(8,2) DEFAULT NULL,
  `OverduePrincipalAndInte` float(8,2) DEFAULT NULL,
  `CurrentPeriod` int(11) DEFAULT NULL,
  `AmountOfRepayRecei` float(8,2) DEFAULT NULL,
  `RepaymentsReceived` float(8,2) DEFAULT NULL,
  `RepaymentStatus` varchar(30) DEFAULT NULL,
  `RepaymentDate` date DEFAULT NULL,
  `RepaymentDeadline` date DEFAULT NULL,
  `BorrID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RepaymentPlanDetailsiID`),
  KEY `FK_Reference_37` (`OverdueRepaymentID`),
  KEY `fk_re_borr` (`BorrID`),
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`OverdueRepaymentID`) REFERENCES `overduerepayment` (`OverdueRepaymentID`),
  CONSTRAINT `fk_re_borr` FOREIGN KEY (`BorrID`) REFERENCES `borrowmoneyagreement` (`BorrowMoneyAgreementID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repaymentplandetails
-- ----------------------------
INSERT INTO `repaymentplandetails` VALUES ('48', null, '等额本息还款', '32575.00', '821.18', '0.00', '9', '33396.18', null, '未还', null, '2019-06-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('49', null, '等额本息还款', '32575.00', '821.18', '0.00', '10', '33396.18', null, '未还', null, '2019-07-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('50', null, '等额本息还款', '32575.00', '821.18', '0.00', '5', '33396.18', null, '未还', null, '2019-02-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('51', null, '等额本息还款', '32575.00', '821.18', '0.00', '6', '33396.18', null, '未还', null, '2019-03-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('52', null, '等额本息还款', '32575.00', '821.18', '0.00', '2', '33396.18', null, '未还', null, '2018-11-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('53', null, '等额本息还款', '32575.00', '821.18', '0.00', '3', '33396.18', null, '未还', null, '2018-12-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('54', null, '等额本息还款', '41666.67', '1145.83', '0.00', '1', '42812.50', '42813.00', '已还', '2018-09-01', '2018-10-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('55', null, '等额本息还款', '32575.00', '821.18', '0.00', '8', '33396.18', null, '未还', null, '2019-05-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('56', null, '等额本息还款', '32575.00', '821.18', '0.00', '12', '33396.18', null, '未还', null, '2019-09-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('57', null, '等额本息还款', '32575.00', '821.18', '0.00', '11', '33396.18', null, '未还', null, '2019-08-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('58', null, '等额本息还款', '32575.00', '821.18', '0.00', '4', '33396.18', null, '未还', null, '2019-01-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('59', null, '等额本息还款', '32575.00', '821.18', '0.00', '7', '33396.18', null, '未还', null, '2019-04-01', '6');
INSERT INTO `repaymentplandetails` VALUES ('60', null, null, '100000.00', '0.00', '0.00', '0', '100000.00', '100000.00', '提前还款', '2018-09-01', null, '6');

-- ----------------------------
-- Table structure for repayprincprove
-- ----------------------------
DROP TABLE IF EXISTS `repayprincprove`;
CREATE TABLE `repayprincprove` (
  `RepayPrincProveID` int(11) NOT NULL AUTO_INCREMENT,
  `MaterialTypeID` int(11) DEFAULT NULL,
  `loanAgreement` varchar(50) DEFAULT NULL,
  `AmountMoney` float(8,2) DEFAULT NULL,
  `MarriageCertificate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RepayPrincProveID`),
  KEY `FK_r_41` (`MaterialTypeID`),
  CONSTRAINT `FK_r_41` FOREIGN KEY (`MaterialTypeID`) REFERENCES `materialtype` (`MaterialTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repayprincprove
-- ----------------------------

-- ----------------------------
-- Table structure for retireti
-- ----------------------------
DROP TABLE IF EXISTS `retireti`;
CREATE TABLE `retireti` (
  `RetireID` int(11) NOT NULL AUTO_INCREMENT,
  `MaterialTypeID` int(11) DEFAULT NULL,
  `MyName` varchar(50) DEFAULT NULL,
  `UtinName` varchar(50) DEFAULT NULL,
  `ReasForRe` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RetireID`),
  KEY `FK_r_40` (`MaterialTypeID`),
  CONSTRAINT `FK_r_40` FOREIGN KEY (`MaterialTypeID`) REFERENCES `materialtype` (`MaterialTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of retireti
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) DEFAULT NULL,
  `rtype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '可以操作所有');
INSERT INTO `role` VALUES ('2', '经理', '各种审批');
INSERT INTO `role` VALUES ('12', '柜台业务员', '各种申请');
INSERT INTO `role` VALUES ('13', '超级管理员', '各种功能');

-- ----------------------------
-- Table structure for roleemployee
-- ----------------------------
DROP TABLE IF EXISTS `roleemployee`;
CREATE TABLE `roleemployee` (
  `PersonalManagementID` int(11) NOT NULL,
  `RoleID` int(11) NOT NULL,
  KEY `FK_r_35` (`PersonalManagementID`),
  KEY `FK_r_36` (`RoleID`),
  CONSTRAINT `roleemployee_ibfk_1` FOREIGN KEY (`PersonalManagementID`) REFERENCES `personalmanagement` (`PersonalManagementID`),
  CONSTRAINT `roleemployee_ibfk_2` FOREIGN KEY (`RoleID`) REFERENCES `rolemanagement` (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleemployee
-- ----------------------------

-- ----------------------------
-- Table structure for rolemanagement
-- ----------------------------
DROP TABLE IF EXISTS `rolemanagement`;
CREATE TABLE `rolemanagement` (
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  `RoleDescribe` varchar(200) DEFAULT NULL,
  `RoleGrade` int(11) DEFAULT NULL,
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经理   0\r\n柜台专员  1\r\n审批专员  1\r\n   ';

-- ----------------------------
-- Records of rolemanagement
-- ----------------------------

-- ----------------------------
-- Table structure for rolepowers
-- ----------------------------
DROP TABLE IF EXISTS `rolepowers`;
CREATE TABLE `rolepowers` (
  `RPid` int(11) NOT NULL AUTO_INCREMENT,
  `Rid` int(11) NOT NULL,
  `Pid` int(11) NOT NULL,
  PRIMARY KEY (`RPid`),
  KEY `kf_RP_rid` (`Rid`),
  KEY `kf_RP_pid` (`Pid`),
  CONSTRAINT `rolepowers_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `powers` (`pid`),
  CONSTRAINT `rolepowers_ibfk_2` FOREIGN KEY (`Rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolepowers
-- ----------------------------
INSERT INTO `rolepowers` VALUES ('1', '1', '1');
INSERT INTO `rolepowers` VALUES ('2', '1', '2');
INSERT INTO `rolepowers` VALUES ('3', '1', '3');
INSERT INTO `rolepowers` VALUES ('4', '1', '36');
INSERT INTO `rolepowers` VALUES ('5', '1', '4');
INSERT INTO `rolepowers` VALUES ('44', '1', '37');
INSERT INTO `rolepowers` VALUES ('45', '1', '38');
INSERT INTO `rolepowers` VALUES ('46', '1', '39');
INSERT INTO `rolepowers` VALUES ('56', '1', '40');
INSERT INTO `rolepowers` VALUES ('57', '1', '41');
INSERT INTO `rolepowers` VALUES ('58', '1', '42');
INSERT INTO `rolepowers` VALUES ('59', '1', '43');
INSERT INTO `rolepowers` VALUES ('60', '1', '44');
INSERT INTO `rolepowers` VALUES ('61', '1', '45');
INSERT INTO `rolepowers` VALUES ('62', '1', '46');
INSERT INTO `rolepowers` VALUES ('65', '1', '47');
INSERT INTO `rolepowers` VALUES ('66', '1', '48');
INSERT INTO `rolepowers` VALUES ('67', '1', '49');
INSERT INTO `rolepowers` VALUES ('68', '1', '50');
INSERT INTO `rolepowers` VALUES ('69', '1', '51');
INSERT INTO `rolepowers` VALUES ('71', '1', '53');
INSERT INTO `rolepowers` VALUES ('72', '1', '54');
INSERT INTO `rolepowers` VALUES ('75', '1', '55');
INSERT INTO `rolepowers` VALUES ('76', '1', '56');
INSERT INTO `rolepowers` VALUES ('77', '1', '57');
INSERT INTO `rolepowers` VALUES ('78', '1', '58');
INSERT INTO `rolepowers` VALUES ('79', '1', '59');
INSERT INTO `rolepowers` VALUES ('84', '1', '60');
INSERT INTO `rolepowers` VALUES ('85', '1', '61');
INSERT INTO `rolepowers` VALUES ('86', '1', '62');
INSERT INTO `rolepowers` VALUES ('87', '1', '63');
INSERT INTO `rolepowers` VALUES ('89', '1', '65');
INSERT INTO `rolepowers` VALUES ('90', '1', '66');
INSERT INTO `rolepowers` VALUES ('125', '2', '4');
INSERT INTO `rolepowers` VALUES ('126', '2', '37');
INSERT INTO `rolepowers` VALUES ('127', '2', '38');
INSERT INTO `rolepowers` VALUES ('129', '2', '42');
INSERT INTO `rolepowers` VALUES ('130', '2', '47');
INSERT INTO `rolepowers` VALUES ('131', '2', '59');
INSERT INTO `rolepowers` VALUES ('132', '2', '58');
INSERT INTO `rolepowers` VALUES ('133', '2', '46');
INSERT INTO `rolepowers` VALUES ('134', '2', '56');
INSERT INTO `rolepowers` VALUES ('135', '2', '65');
INSERT INTO `rolepowers` VALUES ('136', '2', '57');
INSERT INTO `rolepowers` VALUES ('137', '13', '4');
INSERT INTO `rolepowers` VALUES ('138', '13', '36');
INSERT INTO `rolepowers` VALUES ('139', '13', '37');
INSERT INTO `rolepowers` VALUES ('140', '13', '38');
INSERT INTO `rolepowers` VALUES ('141', '13', '39');
INSERT INTO `rolepowers` VALUES ('142', '13', '40');
INSERT INTO `rolepowers` VALUES ('143', '13', '41');
INSERT INTO `rolepowers` VALUES ('144', '13', '42');
INSERT INTO `rolepowers` VALUES ('145', '13', '43');
INSERT INTO `rolepowers` VALUES ('146', '13', '44');
INSERT INTO `rolepowers` VALUES ('147', '13', '45');
INSERT INTO `rolepowers` VALUES ('148', '13', '46');
INSERT INTO `rolepowers` VALUES ('149', '13', '47');
INSERT INTO `rolepowers` VALUES ('150', '13', '48');
INSERT INTO `rolepowers` VALUES ('151', '13', '49');
INSERT INTO `rolepowers` VALUES ('152', '13', '50');
INSERT INTO `rolepowers` VALUES ('153', '13', '51');
INSERT INTO `rolepowers` VALUES ('154', '13', '53');
INSERT INTO `rolepowers` VALUES ('155', '13', '54');
INSERT INTO `rolepowers` VALUES ('156', '13', '55');
INSERT INTO `rolepowers` VALUES ('157', '13', '56');
INSERT INTO `rolepowers` VALUES ('158', '13', '57');
INSERT INTO `rolepowers` VALUES ('159', '13', '58');
INSERT INTO `rolepowers` VALUES ('160', '13', '59');
INSERT INTO `rolepowers` VALUES ('161', '13', '60');
INSERT INTO `rolepowers` VALUES ('162', '13', '61');
INSERT INTO `rolepowers` VALUES ('163', '13', '62');
INSERT INTO `rolepowers` VALUES ('164', '13', '63');
INSERT INTO `rolepowers` VALUES ('165', '13', '65');
INSERT INTO `rolepowers` VALUES ('166', '13', '66');
INSERT INTO `rolepowers` VALUES ('168', '12', '36');
INSERT INTO `rolepowers` VALUES ('170', '12', '39');
INSERT INTO `rolepowers` VALUES ('171', '12', '41');
INSERT INTO `rolepowers` VALUES ('172', '12', '45');
INSERT INTO `rolepowers` VALUES ('173', '12', '50');
INSERT INTO `rolepowers` VALUES ('174', '12', '40');
INSERT INTO `rolepowers` VALUES ('175', '12', '43');
INSERT INTO `rolepowers` VALUES ('176', '12', '44');
INSERT INTO `rolepowers` VALUES ('177', '12', '49');
INSERT INTO `rolepowers` VALUES ('178', '12', '51');
INSERT INTO `rolepowers` VALUES ('179', '12', '58');
INSERT INTO `rolepowers` VALUES ('180', '12', '59');
INSERT INTO `rolepowers` VALUES ('181', '12', '61');
INSERT INTO `rolepowers` VALUES ('182', '12', '66');
INSERT INTO `rolepowers` VALUES ('183', '12', '62');
INSERT INTO `rolepowers` VALUES ('184', '12', '55');
INSERT INTO `rolepowers` VALUES ('185', '12', '60');
INSERT INTO `rolepowers` VALUES ('186', '12', '54');
INSERT INTO `rolepowers` VALUES ('187', '12', '53');
INSERT INTO `rolepowers` VALUES ('189', '12', '37');
INSERT INTO `rolepowers` VALUES ('190', '12', '57');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `sname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `FK8FFE823BE7301C93` (`cid`),
  CONSTRAINT `FK8FFE823BE7301C93` FOREIGN KEY (`cid`) REFERENCES `classes` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for supdetailed
-- ----------------------------
DROP TABLE IF EXISTS `supdetailed`;
CREATE TABLE `supdetailed` (
  `SupDetailedID` int(11) NOT NULL AUTO_INCREMENT,
  `ApplyID` int(11) DEFAULT NULL,
  `EmployeeName` varchar(30) DEFAULT NULL,
  `SupMoney` float(8,2) DEFAULT NULL,
  `SupMonth` int(11) DEFAULT NULL,
  `SupRadices` float(8,2) DEFAULT NULL,
  `SupDate` varchar(50) DEFAULT NULL,
  `IndDepositRatio` float(8,2) DEFAULT NULL,
  `IndAccountID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SupDetailedID`),
  KEY `FK_r_16` (`ApplyID`),
  KEY `dw` (`IndAccountID`),
  CONSTRAINT `dw` FOREIGN KEY (`IndAccountID`) REFERENCES `indaccountinfo` (`IndAccountID`),
  CONSTRAINT `FK_r_16` FOREIGN KEY (`ApplyID`) REFERENCES `utinsupapply` (`ApplyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全部补缴\r\n部分补缴';

-- ----------------------------
-- Records of supdetailed
-- ----------------------------

-- ----------------------------
-- Table structure for unitinfo
-- ----------------------------
DROP TABLE IF EXISTS `unitinfo`;
CREATE TABLE `unitinfo` (
  `UtinID` int(11) NOT NULL AUTO_INCREMENT,
  `UtinName` varchar(50) DEFAULT NULL,
  `UtinNumber` varchar(50) DEFAULT NULL,
  `UtinAddress` varchar(50) DEFAULT NULL,
  `CorpRepr` varchar(50) DEFAULT NULL,
  `OperatorName` varchar(50) DEFAULT NULL,
  `OperatorPhone` varchar(50) DEFAULT NULL,
  `OperatorIDNumber` varchar(50) DEFAULT NULL,
  `BankName` varchar(50) DEFAULT NULL,
  `UtinFoundDate` date DEFAULT NULL,
  `UtinOpenDate` date DEFAULT NULL,
  `AdmissibleNetwork` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UtinID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unitinfo
-- ----------------------------
INSERT INTO `unitinfo` VALUES ('4', 'AAA软件教育', '410222199807109830', '河南郑州郑州市二七区政通路庆丰街交叉口西50米', 'A法人', 'A经办人', '18569850710', '410222199807109830', '中国银行', '2018-10-01', '2018-10-01', null);
INSERT INTO `unitinfo` VALUES ('5', 'Oracle公司', '4102221998945793', '美国加州红木城', '劳伦斯·埃里森', '劳伦斯·埃里森', '15896897669', '4102221998945793', '中国银行', '2018-10-01', '2018-10-01', null);
INSERT INTO `unitinfo` VALUES ('6', 'Microsoft', '410222199807109830', '美国华盛顿州雷德蒙德市', '比尔·盖茨', '保罗·艾伦', '13569541609', '410222199807109830', '中国银行', '2018-10-01', '2018-10-01', null);
INSERT INTO `unitinfo` VALUES ('7', '甲骨文股份有限公司', '410222199807109830', '纽约', '甲骨文', '经办人', '13569541609', '410222199807109830', '中国银行', '2018-10-02', '2018-10-01', null);

-- ----------------------------
-- Table structure for useoffunds
-- ----------------------------
DROP TABLE IF EXISTS `useoffunds`;
CREATE TABLE `useoffunds` (
  `UseOfFundsID` int(11) NOT NULL AUTO_INCREMENT,
  `UseDescription` varchar(100) DEFAULT NULL,
  `RemarkInfo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`UseOfFundsID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品房\r\n经济适用房\r\n二手房\r\n';

-- ----------------------------
-- Records of useoffunds
-- ----------------------------
INSERT INTO `useoffunds` VALUES ('1', '商品房', null);
INSERT INTO `useoffunds` VALUES ('2', '经济房', null);
INSERT INTO `useoffunds` VALUES ('3', '二手房', null);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `unum` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `upass` varchar(255) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `udescription` varchar(255) DEFAULT NULL,
  `ustatic` int(1) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `unum` (`unum`),
  KEY `kf_rid` (`rid`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', 'admin', 'admin', '1', '1');
INSERT INTO `users` VALUES ('2', 'orcl', 'tiger', 'orcl', 'tiger', '1', '2');
INSERT INTO `users` VALUES ('4', 'orcl2', 'tiger', 'orcl2', '410025199711014925', '1', '12');

-- ----------------------------
-- Table structure for utinaccountinfo
-- ----------------------------
DROP TABLE IF EXISTS `utinaccountinfo`;
CREATE TABLE `utinaccountinfo` (
  `UtinAccountID` int(11) NOT NULL AUTO_INCREMENT,
  `UtinID` int(11) DEFAULT NULL,
  `AccountStatus` varchar(20) DEFAULT NULL,
  `UtinDepositRatio` double(10,2) DEFAULT NULL,
  `UtinSumPeople` int(11) DEFAULT NULL,
  `UtinDepositPeople` int(11) DEFAULT NULL,
  `UtinSealPeople` int(11) DEFAULT NULL,
  `UtinProvRema` double(10,0) DEFAULT NULL,
  `UtinPayinWay` varchar(20) DEFAULT NULL,
  `UtinAccountPass` varchar(50) DEFAULT NULL,
  `UtinName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UtinAccountID`),
  KEY `FK_r_UtinID` (`UtinID`),
  CONSTRAINT `FK_r_UtinID` FOREIGN KEY (`UtinID`) REFERENCES `unitinfo` (`UtinID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of utinaccountinfo
-- ----------------------------
INSERT INTO `utinaccountinfo` VALUES ('4', '4', '正常', '0.12', '6', '4', '2', '77400', '柜台缴纳', '4', 'AAA软件教育');
INSERT INTO `utinaccountinfo` VALUES ('5', '5', '正常', '0.12', '0', '0', '0', '0', '柜台缴纳', '5', 'Oracle公司');
INSERT INTO `utinaccountinfo` VALUES ('6', '6', '正常', '0.12', '0', '0', '0', '0', '柜台缴纳', '6', 'Microsoft');
INSERT INTO `utinaccountinfo` VALUES ('7', '7', '审核中', '0.12', '0', '0', '0', '0', '柜台缴纳', '7', '甲骨文股份有限公司');

-- ----------------------------
-- Table structure for utinremittancedetail
-- ----------------------------
DROP TABLE IF EXISTS `utinremittancedetail`;
CREATE TABLE `utinremittancedetail` (
  `UtinRDID` int(11) NOT NULL AUTO_INCREMENT,
  `UtinAccountID` int(11) DEFAULT NULL,
  `UtinName` varchar(50) DEFAULT NULL,
  `PayinSumMoney` double(8,2) DEFAULT NULL,
  `DepositPeople` int(50) DEFAULT NULL,
  `DepositDate` varchar(50) DEFAULT NULL,
  `adminname` varchar(255) DEFAULT NULL,
  `remonth` varchar(255) DEFAULT NULL,
  `finaldate` varchar(255) DEFAULT NULL,
  `oridate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UtinRDID`),
  KEY `fk_utin_rd` (`UtinAccountID`),
  CONSTRAINT `utinremittancedetail_ibfk_1` FOREIGN KEY (`UtinAccountID`) REFERENCES `utinaccountinfo` (`UtinAccountID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of utinremittancedetail
-- ----------------------------
INSERT INTO `utinremittancedetail` VALUES ('8', '4', 'AAA软件教育', '22800.00', '6', '2018-05-01 07:07', ' admin', '1', '2018-05', '2018-05');
INSERT INTO `utinremittancedetail` VALUES ('9', '4', 'AAA软件教育', '45600.00', '6', '2018-06-01 07:08', ' ', '2', '2018-06', '2018-05');
INSERT INTO `utinremittancedetail` VALUES ('10', '4', 'AAA软件教育', '68400.00', '6', '2018-06-01 07:10', ' ', '3', '2018-06', '2018-04');
INSERT INTO `utinremittancedetail` VALUES ('11', '4', 'AAA软件教育', '45600.00', '6', '2018-07-01 07:15', ' ', '2', '2018-07', '2018-06');

-- ----------------------------
-- Table structure for utinsupapply
-- ----------------------------
DROP TABLE IF EXISTS `utinsupapply`;
CREATE TABLE `utinsupapply` (
  `ApplyID` int(11) NOT NULL AUTO_INCREMENT,
  `UtinAccountID` int(11) DEFAULT NULL,
  `ApplyUtin` varchar(50) DEFAULT NULL,
  `UtinOperator` varchar(30) DEFAULT NULL,
  `SupCause` varchar(50) DEFAULT NULL,
  `ApplyDate` varchar(50) DEFAULT NULL,
  `utinsupmoney` double(255,0) DEFAULT NULL,
  `UtinNmae` varchar(255) DEFAULT NULL,
  `chequeID` varchar(50) DEFAULT NULL,
  `supSumple` int(11) DEFAULT NULL,
  PRIMARY KEY (`ApplyID`),
  KEY `FK_r_17` (`UtinAccountID`),
  CONSTRAINT `FK_r_17` FOREIGN KEY (`UtinAccountID`) REFERENCES `utinaccountinfo` (`UtinAccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of utinsupapply
-- ----------------------------
