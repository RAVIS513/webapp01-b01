#!/bin/sh -xe

# *********************************************************
# * バッチファイル名 ：BatchRunner.sh
# *
# * 終了コード       ：0（正常終了）
# *                  ：1（異常終了）
# * 処理概要         ：バッチプロセスの呼び出し
# *********************************************************
# * 改定日     改定内容
# * ---------- --------------------------------------------
# * 2016/09/08 新規作成
# * 2016/11/14 クラスパスを絶対パスに変更（jenkinsより実行するため）
# *
# *
# *********************************************************

echo `date` バッチ開始

CLASSPATH="/home/tomcat/batch/histsite/properties"
for jar in `ls /home/tomcat/batch/histsite/classes/*.jar`; do
 CLASSPATH="${CLASSPATH}:${jar}"
done

RUNDATE=`date '+%Y%m%d'`

java -cp ${CLASSPATH} jp.ne.ravisite.runner.BatchRunner ${RUNDATE}

RESULT=$?

if [ ${RESULT} = 1 ]; then
 echo "エラーが発生しました" ${RESULT}
exit 1
fi

echo `date` バッチ終了 ${RESULT}
exit 0
