#!/bin/bash

set -e

no_test=0
no_lint=0

while (( $# > 0 )); do
   case "$1" in
   	--help)
			printf "run.sh [OPTION]... [PKG]\n"
			printf "options:\n"
			printf "\t--help			Show help\n"
			printf "\t--no-test		Skip tests\n"
			printf "\t--no-lint		Skip linting\n"
			exit 0
      	;;
      --no-test)
			no_test=1
			shift
      	;;
      --no-lint)
			no_lint=1
			shift
			;;
		*)
			break
	      ;;
   esac
done

if (( no_test == 0 )); then
  if [[ -z "$1" ]]; then
    sbt -warn test
  else
    green='\033[1;32m'
    no_color='\033[0m'
	printf "Running tests in the package: %b%s%b\n" "$green" "$1" "$no_color"
    sbt -warn "Test / testOnly $1*"
  fi
fi

if (( no_lint == 0 )); then
	if [[ -z "${CI}" ]]; then
	  sbt -warn scalafmtAll
	else
	  sbt -warn scalafmtCheckAll
	fi
fi
