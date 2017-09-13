echo "Setting commit hash.."
LAST_GIT_COMMIT_HASH=${HEROKU_SLUG_COMMIT:?$(git rev-parse HEAD)}
export LAST_GIT_COMMIT_HASH=$LAST_GIT_COMMIT_HASH
echo "Commit hash is set to $LAST_GIT_COMMIT_HASH"
