#!/bin/sh

# *********************************************************
# * バッチファイル名	：BatchRunner.bat
# *
# * 終了コード		：0（正常終了）
# * 			：1（異常終了）
# * 処理概要		：バッチプロセスの呼び出し
# *********************************************************
# * 改定日     改定内容
# * ---------- --------------------------------------------
# * 2016/09/08 新規作成
# *
# *
# *********************************************************

echo `date` バッチ開始

CLASSPATH="./properties"
for jar in `ls classes/*.jar`; do
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
